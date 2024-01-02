package src.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.View.LoginView;

public class LoginTest {
    private LoginView loginView;

    @Before
    public void setUp() {
        loginView = new LoginView();
    }

    @Test
    public void testDefaultUsernames() {
        String defaultPlayer1Name = loginView.getUsername1();
        String defaultPlayer2Name = loginView.getUsername2();

        Assert.assertEquals("Player1", defaultPlayer1Name);
        Assert.assertEquals("Player2", defaultPlayer2Name);
    }

    @Test
    public void testSettingUsernames() {
        loginView.t_username1.setText("Alice");
        loginView.t_username2.setText("Bob");
        loginView.ok1.doClick();

        String newPlayer1Name = loginView.getUsername1();
        String newPlayer2Name = loginView.getUsername2();

        Assert.assertEquals("Alice", newPlayer1Name);
        Assert.assertEquals("Bob", newPlayer2Name);
    }
}
