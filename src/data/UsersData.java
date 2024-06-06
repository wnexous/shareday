package data;

import controllers.DataController;
import controllers.HashController;
import types.DataColumnTypes;
import types.UserTypes;

public class UsersData extends DataController {

    private DataColumnTypes userColumn = new DataColumnTypes("username");
    private DataColumnTypes passColumn = new DataColumnTypes("password");

    public UsersData() {
        super("UsersData.txt");
    }

    public UserTypes getUserByUsername(String username) {
        String[] useyArray = this.findItemByColumn(username, userColumn);

        // Caso nao encontre o usuario na tabela, retorna nulo
        if (useyArray == null)
            return null;

        String usernameData = useyArray[this.getIndexFromColumn(userColumn)];
        String passwordData = useyArray[this.getIndexFromColumn(passColumn)];

        UserTypes userController = new UserTypes(usernameData, passwordData);
        return userController;
    }

    public void createUser(UserTypes user) {
        String hashPassword = HashController.encode(user.getPassword());
        String[] userRow = new String[] { user.getUsername(), hashPassword };
        this.appendRow(userRow);
    }
}
