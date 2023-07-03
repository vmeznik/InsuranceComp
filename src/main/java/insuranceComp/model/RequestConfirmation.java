package insuranceComp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RequestConfirmation implements Serializable {
    @SerializedName("success")
    private boolean success;
    @SerializedName("error")
    private String error;

    public RequestConfirmation(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public RequestConfirmation() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}