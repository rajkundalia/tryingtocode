package cognitree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        String filePath = args[0];
        Integer N = Integer.valueOf(args[1]);
        String O = args[2];
        List<Car> cars = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String strCurrentLine;
            br.readLine();
            Car car = null;
            while ((strCurrentLine = br.readLine()) != null) {
                car = new Car(strCurrentLine);
                cars.add(car);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        findCarsAndPrint(cars, N, O);
    }

    static void findCarsAndPrint(List<Car> cars, Integer n, String o) {

        List<Car> listOfCars = cars.stream().filter(car -> (car.getCountry() == o))
                .collect(Collectors.toList());
        double averageHP = listOfCars.stream().mapToDouble(car -> car.getHorsePower())
                .average()
                .orElse(0);
        List<Car> carsWithHigherHP = listOfCars.stream().filter(car -> car.getHorsePower() > averageHP)
                .sorted(Comparator.comparing(Car::getHorsePower).reversed())
                .collect(Collectors.toList());
        for (int i = 0; i < n; i++) {
            System.out.println(carsWithHigherHP.get(i));
        }
    }
}
