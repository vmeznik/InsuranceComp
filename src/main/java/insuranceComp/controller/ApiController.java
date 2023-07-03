package insuranceComp.controller;

import insuranceComp.model.Client;
import insuranceComp.model.Employee;
import insuranceComp.model.RequestConfirmation;
import insuranceComp.repostiroy.IClientRepository;
import insuranceComp.repostiroy.IEmployeeRepository;
import insuranceComp.utility.IdGenerator;
import insuranceComp.utility.Logger;
import insuranceComp.utility.NullChecker;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {
    private final IClientRepository clientRepository;
    private final IEmployeeRepository employeeRepository;

    public ApiController(IClientRepository clientRepository, IEmployeeRepository employeeRepository) {
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("insuranceComp/registerEmployee")
    public RequestConfirmation registerEmployee(@RequestBody Employee employee) {
        return regEmp(employee);
    }

    @PostMapping("insuranceComp/loginEmployee")
    public RequestConfirmation loginEmployee(@RequestBody Employee employee) {
        return logEmp(employee);
    }


    @PostMapping("insuranceComp/addClient")
    public RequestConfirmation addClient(@RequestBody Client client) {
        return addClientToDb(client);
    }


    @PostMapping("insuranceComp/clientInfo")
    public Client clientInfo(@RequestBody Client client) {
        return getClientInfo(client);
    }

    @PostMapping("insuranceComp/updateClient")
    public RequestConfirmation updateClient(@RequestBody Client client) {
        return updateClientInfo(client);
    }


    private RequestConfirmation regEmp(Employee employee) {
        try {
            employee.setId(generateEmpId());
            if (NullChecker.hasNullFields(employee)) {
                return new RequestConfirmation(false, "not everything is filled");
            }

            if (!employeeRepository.emailExists(employee.getEmail()).isEmpty()) {
                Logger.getInstance().log(employee + " tried to register , but wasnt confirmed");
                return new RequestConfirmation(false, "Email already exists");
            }

            employeeRepository.save(employee);
            Logger.getInstance().log(employee + " was registered");
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getInstance().log(employee + " tried to register , but wasnt confirmed");
            return new RequestConfirmation(false, "User was not registered");
        }
        return new RequestConfirmation(true, null);
    }

    private RequestConfirmation logEmp(Employee employee) {
        try {
            if (employeeRepository.loginEmployee(employee.getEmail(), employee.getPassword()) == null) {
                Logger.getInstance().log(employee + " tried to log in , but wasnt confirmed");
                return new RequestConfirmation(false, "Wrong username or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new RequestConfirmation(false, "Something went wrong");
        }
        Logger.getInstance().log(employee + " logged in");
        return new RequestConfirmation(true, null);

    }

    private RequestConfirmation addClientToDb(Client client) {
        try {
            client.setId(generateClientId());
            if (NullChecker.hasNullFields(client)) {
                return new RequestConfirmation(false, "not everything is filled");
            }
            if (!clientRepository.emailExists(client.getEmail()).isEmpty()) {
                Logger.getInstance().log(client + " tried to register , but wasnt confirmed");
                return new RequestConfirmation(false, "Email already exists");
            }
            if (!clientRepository.phoneExists(client.getPhone()).isEmpty()) {
                Logger.getInstance().log(client + " tried to register , but wasnt confirmed");
                return new RequestConfirmation(false, "Email already exists");
            }
            clientRepository.save(client);
        } catch (Exception e) {
            e.printStackTrace();
            return new RequestConfirmation(false, "Something went wrong");
        }
        Logger.getInstance().log(client + " was added");
        return new RequestConfirmation(true, null);
    }

    private Client getClientInfo(Client client) {
        try {
            if (client.getId() == null) {
                return new Client();
            }
            Client clientInfo = clientRepository.getClientById(client.getId());
            if (clientInfo != null) {
                return clientInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Client();
    }

    private RequestConfirmation updateClientInfo(Client client) {
        try {
            if (client.getFirstName() != null) {
                clientRepository.changeFirstName(client.getFirstName(), client.getId());
            }

            if (client.getLastName() != null) {
                clientRepository.changeLastName(client.getLastName(), client.getId());
            }

            if (client.getEmployer() != null) {
                clientRepository.changeEmployer(client.getEmployer(), client.getId());
            }

            if (client.getEmail() != null) {
                clientRepository.changeEmail(client.getEmail(), client.getId());
            }

            if (client.getPhone() != null) {
                clientRepository.changePhone(client.getPhone(), client.getId());
            }

            if (client.getDebt() != -1) {
                clientRepository.changeDebt(client.getDebt(), client.getId());
            }

            if (client.getAddress() != null) {
                clientRepository.changeAddress(client.getAddress(), client.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new RequestConfirmation(false, "Something went wrong");
        }
        return new RequestConfirmation(true, null);
    }

    private String generateEmpId() {
        String id = IdGenerator.generateEmployeeId();
        while (!employeeRepository.idExists(id).isEmpty()) {
            id = IdGenerator.generateEmployeeId();
        }
        return id;
    }

    private String generateClientId() {
        String id = IdGenerator.generateClientId();
        while (!clientRepository.idExists(id).isEmpty()) {
            id = IdGenerator.generateEmployeeId();
        }
        return id;
    }

}
