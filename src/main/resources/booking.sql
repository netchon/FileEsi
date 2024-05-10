CREATE TABLE IF NOT EXISTS bookings (
    id SERIAL PRIMARY KEY,
    customer_name VARCHAR(100),
    room_number VARCHAR(10),
    check_in_date VARCHAR(20),
    check_out_date VARCHAR(20)
    );