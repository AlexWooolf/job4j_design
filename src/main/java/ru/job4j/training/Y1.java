package ru.job4j.training;

import java.util.*;

public class Y1 {

    static class Person {
        String name;
        byte day;
        byte month;
        short year;

        public Person(String name, byte day, byte month, short year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        public String getName() {
            return name;
        }

        public byte getDay() {
            return day;
        }

        public byte getMonth() {
            return month;
        }

        public short getYear() {
            return year;
        }
    }

    public static void main(String[] args) {
        var codedPersons = input(); // вся магия тут
        List<String> rsl = new ArrayList<>(codedPersons.values()); // тут приведение к виду требуемого вывода
        StringBuilder output = new StringBuilder();
        for (String str : rsl) {
            output.append(str).append(" ");
        }
        output.deleteCharAt(output.length() - 1);
        System.out.println(output);
    }

    public static Map<Person, String> input() {
        Scanner scanner = new Scanner(System.in);
        short count = scanner.nextShort();
        scanner.nextLine();
        Map<Character, Integer> dictionary = new HashMap<>(); // создаю словарь, из которого буду брать номер буквы в алфавите
        int index = 1;
        for (char i = 'A'; i <= 'Z'; i++) {
            dictionary.put(i, index);
            index++;
        }
        Map<Person, String> codedPersons = new LinkedHashMap<>(); //сразу делаю мапу где будет персон и его шифр
        for (int i = 0; i < count; i++) {
            var input = scanner.nextLine().split(",");
            StringBuilder name = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                name.append(input[j]);
            }
            Person person = new Person(name.toString(), Byte.parseByte(input[3]), Byte.parseByte(input[4]), Short.parseShort(input[5])); // создаю персонов с ФИО в одну строку
            codedPersons.put(person, getCode(person, dictionary));
        }
        return codedPersons;
    }

    public static String getCode(Person person, Map<Character, Integer> dictionary) { //тут делаю шифр
        HashSet<Character> symbols = new HashSet<>();
        for (int i = 0; i < person.getName().length(); i++) {
            symbols.add(person.getName().charAt(i));
        }
        var day = String.valueOf(person.getDay()).toCharArray();
        var month = String.valueOf(person.getMonth()).toCharArray();
        int sumDay = 0;
        int sumMonth = 0;
        for (char c : day) {
            sumDay = sumDay + Character.getNumericValue(c);
        }
        for (char c : month) {
            sumMonth = sumMonth + Character.getNumericValue(c);
        }
        int codeDate = (sumDay + sumMonth) * 64;
        String code = Integer.toHexString(codeDate + symbols.size() + dictionary.get(person.getName().charAt(0)) * 256).toUpperCase(Locale.ROOT); //перевод в 16-чную систему
        if (code.length() < 3) { // добавляю нули если получившийся код меньше 3 знаков
            code = "000" + code;
        }
        return code.substring(code.length() - 3); // обрезка
    }
}
