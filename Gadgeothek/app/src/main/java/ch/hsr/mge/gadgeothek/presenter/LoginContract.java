package ch.hsr.mge.gadgeothek.presenter;

/**
 * Created by s on 10/28/17.
 */

public interface LoginContract {

    public interface View {

        public void resetCredentials();
        public void setCredentials(String email, String password);
    }

    public interface UserActionsListener {

        public void setupView();
    }
}
