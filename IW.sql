CREATE TABLE service (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    price FLOAT
                     );

CREATE TABLE season (
    id SERIAL PRIMARY KEY,
    type VARCHAR(255),
    season_start DATE,
    season_end DATE,
    multiplier DOUBLE PRECISION
                    );

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    surname VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    phone VARCHAR(255),
    payment_method VARCHAR(255),
    type VARCHAR(255)
                   );

CREATE TABLE room (
    id SERIAL PRIMARY KEY,
    floor INTEGER,
    code VARCHAR(255),
    people INTEGER,
    type VARCHAR(255),
    base_price VARCHAR(255),
    description VARCHAR(255),
    active BOOLEAN
                  );

CREATE TABLE booking (
    id SERIAL PRIMARY KEY,
    user_id INTEGER,
    room_id INTEGER,
    season_id INTEGER,
    start_date DATE,
    end_date DATE,
    total_price FLOAT,
    notes VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (room_id) REFERENCES room(id),
    FOREIGN KEY (season_id) REFERENCES season(id)
                     );

CREATE TABLE booking_service (
    id SERIAL PRIMARY KEY,
    booking_id INTEGER,
    service_id INTEGER,
    FOREIGN KEY (booking_id) REFERENCES booking(id),
    FOREIGN KEY (service_id) REFERENCES service(id)
);
