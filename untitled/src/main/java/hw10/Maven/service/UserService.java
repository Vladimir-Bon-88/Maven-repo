package hw10.Maven.service;

import hw10.Maven.model.User;

import java.util.List;

public interface UserService {
    /**
     * Добавление пользователя в файл
     * @param user - пользователь
     */
    void addToFile(User user);

    /**
     * Удаление пользователя из файла, если он существует
     * @param user - пользователь
     */
    void remove(User user);

    /**
     * Получение пользователя по его id
     * @param id - id пользователя
     * @return - возвращается пользователь с указанным id, если он существует
     */
    User getById(int id);

    /**
     * Получение всех записанных в файл пользователей
     * @return - возвращается список пользователей
     */
    List<User> getAll();
}

