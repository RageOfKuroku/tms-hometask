CREATE TABLE IF NOT EXISTS students (
                                        id int primary key ,
                                        name varchar,
                                        cityID int constraint fk_cities references cities(id)
);


CREATE TABLE IF NOT EXISTS cities (
                                      id int primary key,
                                      name varchar
);