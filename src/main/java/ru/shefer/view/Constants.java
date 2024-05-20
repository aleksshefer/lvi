package ru.shefer.view;

import lombok.Getter;

@Getter
public enum Constants {

    LOG_IN("Войти."),
    REGISTER("Зарегистрироваться."),
    APP_EXIT("Выйти."),
    CREATE_TOPIC("Создать тему. "),
    ENTER_TOPIC_NAME("Введите название темы: "),
    LOOK_OUT_ALL_TOPICS("Посмотреть все темы."),
    GET_INTO_TOPIC("Войти в обсуждение темы."),
    ALL_TOPICS_LIST("Все темы: \n"),
    ALL_POST_LIST("Все сообщения: \n"),
    CHOOSE_POST("Введите навзание или часть названия темы, в которую хотите зайти: "),
    ENTER_POST_TO_DELETE("Введите навзание или часть названия темы, которую хотите удалить: "),
    DELETE_POST("Удалить тему."),
    NO_SUCH_POST("Такой темы нет.\n"),
    CHOOSE_ITEM("Выберите необходимое действие: \n"),
    GET_BACK_TO_MAIN_MENU("Назад  в главное меню"),
    USER_HAS_NO_ROLE("Возникла ошибка. У пользователя нет роли!"),
    WRONG_MENU_INPUT("\nНеправильный ввод, для выбора меню используйте цифры!\n"),
    WRONG_MENU_CHOICE_COUNT("\nВведите цифру, представленную в меню!\n"),
    NO_SUCH_USER_EXIST("\nПо данным параметрам пользователь не найден!\n"),
    ENTER_EMAIL("\nВведите адрес электронной почты:"),
    ENTER_PASSWORD("\nВведите пароль: "),
    ENTER_USER_NAME("\nВведите имя: "),
    ENTER_USER_SURNAME("\nВведите фамилию: "),
    WRONG_PASSWORD("\nПароль неверный! Попробуйте еше раз.\n"),
    NUMBER_OF_ATTEMPTS("\nКоличество попыток: \n"),
    TOPIC_NAME("Название темы:"),
    READ_ALL_POSTS("Прочитать все сообщения."),
    TO_WRITE_POST("Написать сообщение."),
    BACK_TO_TOPIC_MENU("Назад в меню тем."),
    WRITE_POST("Напишите сообщение: ");

    private final String value;

    Constants(String value) {
        this.value = value;
    }
}
