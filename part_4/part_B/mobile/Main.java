package part_4.part_B.mobile;

import part_4.part_B.mobile.model.BasicTariff;
import part_4.part_B.mobile.model.PremiumTariff;
import part_4.part_B.mobile.model.Tariff;
import part_4.part_B.mobile.service.TariffService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Шубин Дмитрий Б762-2 Вариант 12");
        TariffService tariffService = new TariffService();
        Scanner scanner = new Scanner(System.in);

        // Добавление тарифов
        tariffService.addTariff(new BasicTariff("Basic Plan", 9.99, 100));
        tariffService.addTariff(new PremiumTariff("Premium Plan", 19.99, 200));

        // Вывод всех тарифов
        tariffService.displayTariffs();

        while (true) {
            System.out.println("1. Показать общее количество клиентов");
            System.out.println("2. Сортировать тарифы по абонентской плате");
            System.out.println("3. Найти тарифы в заданном диапазоне");
            System.out.println("4. Добавить клиента к тарифу");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Общее количество клиентов: " + tariffService.getTotalCustomers());
                    break;
                case 2:
                    List<Tariff> sortedTariffs = tariffService.sortTariffsByMonthlyFee();
                    sortedTariffs.forEach(tariff -> System.out.println(tariff.getName() + ": " + tariff.getMonthlyFee()));
                    break;
                case 3:
                    System.out.print("Введите минимальную абонентскую плату: ");
                    double min = scanner.nextDouble();
                    System.out.print("Введите максимальную абонентскую плату: ");
                    double max = scanner.nextDouble();
                    List<Tariff> foundTariffs = tariffService.findTariffsInRange(min, max);
                    foundTariffs.forEach(tariff -> System.out.println(tariff.getName() + ": " + tariff.getMonthlyFee()));
                    break;
                case 4:
                    System.out.print("Выберите тариф (1 - Basic Plan, 2 - Premium Plan): ");
                    int tariffChoice = scanner.nextInt();
                    if (tariffChoice == 1) {
                        tariffService.getTariffs().get(0).addCustomer();
                    } else if (tariffChoice == 2) {
                        tariffService.getTariffs().get(1).addCustomer();
                    } else {
                        System.out.println("Неверный выбор тарифа.");
                    }
                    System.out.println("Клиент успешно добавлен.");
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}
