CREATE SCHEMA HealthDiary;
USE HealthDiary; 

CREATE TABLE exercise_records (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    exercise_name VARCHAR(255) NOT NULL,
    series INT UNSIGNED,
    repeats INT UNSIGNED,
    exercise_date_time DATETIME NOT NULL,
    exercise_type ENUM(
        'CORRIDA', 'CAMINHADA', 'NATACAO', 'MUSCULACAO',
        'PEDAL', 'IOGA', 'PILATES', 'OUTRO'
    ) NOT NULL,
    duration_in_minutes DOUBLE,
    exercise_load DOUBLE,
    calories_burned INT UNSIGNED,
    intensity ENUM('LEVE', 'MODERADA', 'INTENSO'),
    notes TEXT,

    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE meal_records (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    meal_date_time DATETIME NOT NULL,
    meal_type ENUM('CAFE_DA_MANHA', 'LANCHE', 'ALMOCO', 'JANTAR', 'CEIA') NOT NULL,
    calories INT NOT NULL CHECK (calories >= 0),
    items TEXT,
    photo_url VARCHAR(255),
    notes TEXT,

    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE sleep_records (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    sleep_start DATETIME NOT NULL,
    sleep_end DATETIME NOT NULL,
    duration_in_hours DOUBLE,
    sleep_stages TEXT,
    sleep_quality ENUM('RUIM', 'BOM', 'REGULAR', 'EXCELENTE'),
    notes TEXT,

    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

SELECT * FROM exercise_records;
SELECT * FROM meal_records;
SELECT * FROM sleep_records;