package hw10.Maven.repository;

import hw10.Maven.utils.Utils;
import hw10.Maven.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final File file;

    public UserRepository() {
        file = new File(Utils.getProp().getProperty("pathname"));
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<User> getAll() {
        return readFromFile();
    }

    private List<User> readFromFile() {
        List<User> users = new ArrayList<>();
        String str;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((str = bufferedReader.readLine()) != null) {
                String[] strArr = str.split(";");
                int id = Integer.parseInt(strArr[0]);
                String name = strArr[1];
                int age = Integer.parseInt(strArr[2]);
                users.add(new User(id, name, age));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }


    public Optional<User> getById(int id) {
        List<User> users = getAll();
        for (User userI : users) {
            if (userI.getId() == id) {
                return Optional.of(userI);
            }
        }
        return Optional.empty();
    }

    public void addToFile(User user) {
        List<User> users = getAll();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.newLine();
            bufferedWriter.write(user.getId() + ";" + user.getName() + ";" + user.getAge());
            users.add(user);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remove(User user) {
        List<User> users = getAll();
        for (User userI : users) {
            if (userI.equals(user)) {
                users.remove(user);
                break;
            }
        }
        save(users);
    }

    private void save(List<User> users) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for(User userI : users) {
                bufferedWriter.write(userI.getId() + ";" + userI.getName() + ";" + userI.getAge());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
