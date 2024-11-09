package com.vasilkovamgkct.lr28;

public class Workout {
    private String name;
    private String description;

    public static final Workout[] workouts = {
            new Workout("The Limb Loosener", "5 минут легких кардио упражнений для разогрева."),
            new Workout("Core Agony", "3 подхода по 30 секунд планки и скручиваний для укрепления пресса."),
            new Workout("Wings of Strength", "3 подхода по 12 отжиманий для тренировки грудных мышц."),
            new Workout("Leg Blaster", "4 подхода по 20 приседаний и 15 выпадов для укрепления ног."),
            new Workout("Full Body Burn", "Комбинированные упражнения для всего тела: 10 минут интенсивной тренировки."),
            new Workout("Back in Action", "3 подхода по 15 тяг гантелей к поясу и гиперэкстензий для тренировки спины."),
            new Workout("Cardio Crush", "Интенсивные 20 минутные кардио-упражнения для сжигания жира."),
            new Workout("Flexibility Boost", "10 минут упражнений на растяжку и гибкость всего тела."),
            new Workout("Power Hour", "30 минут комплексных упражнений с гантелями для силы."),
            new Workout("Endurance Challenge", "15 минут беговых упражнений для выносливости.")
    };

    private Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
}

