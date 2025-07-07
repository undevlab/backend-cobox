-- Sample data for development (will be loaded automatically)
-- Note: This matches your existing JSON data structure

INSERT IGNORE INTO vehicles (id, plate, brand, model, year, type, load_capacity, tank_capacity, status, current_mileage, last_maintenance, active) VALUES
('1', 'ABC-123', 'Toyota', 'Hilux', 2020, 'PICKUP', 1000, 80, 'AVAILABLE', 15000.00, '2023-01-15 00:00:00', true),
('2', 'XYZ-789', 'Mercedes-Benz', 'Actros', 2019, 'TRUCK', 5000, 200, 'IN_ROUTE', 45000.00, '2023-03-10 00:00:00', true),
('3', 'DEF-456', 'Volkswagen', 'Transporter', 2021, 'VAN', 800, 70, 'IN_MAINTENANCE', 8000.00, '2023-05-20 00:00:00', true),
('4', 'ABC-124', 'Toyota', 'Hilux', 2000, 'TRUCK', 1000, 90, 'AVAILABLE', 14000.00, '2025-05-22 05:00:00', true),
('5', 'BCA-123', 'Andre', 'Serrati', 2020, 'VAN', 1000, 22, 'IN_MAINTENANCE', 10000.00, '2025-05-23 05:00:00', true);

INSERT IGNORE INTO mileage_records (id, vehicle_id, date, start_odometer, end_odometer, distance, purpose, route, driver_id, notes, created_by, created_at) VALUES
('1', '1', '2023-05-11 08:00:00', 15000.00, 15250.00, 250.00, 'DELIVERY', 'Lima - Callao', 'D001', 'Entrega regular de mercancía', 'ADMIN', '2023-05-11 16:30:00'),
('2', '2', '2023-05-12 09:15:00', 45000.00, 45600.00, 600.00, 'PICKUP', 'Lima - Huacho', 'D002', 'Recojo de mercadería', 'ADMIN', '2023-05-12 18:45:00'),
('3', '3', '2023-05-13 07:30:00', 8000.00, 8050.00, 50.00, 'MAINTENANCE', 'Visita al taller', 'D001', 'Visita al taller mecánico', 'ADMIN', '2023-05-13 09:00:00');

INSERT IGNORE INTO fuel_records (id, vehicle_id, vehicle_plate, date, fuel_type, quantity, total_cost, current_mileage, station, location, invoice_number, notes) VALUES
('1', 13221, 'ABC-123', '2025-05-22 00:00:00', 'Gasolina Premium', 0.09, 0.07, 10.00, 'AVERAA', 'DASDAS', '12312241', 'DASDASD'),
('2252', 9, 'ABC-123', '2025-05-14 00:00:00', 'Gasolina', 0.10, 0.15, 18.00, 'aaaaaa', 'aaaaaaaaaaa', '111111111111111', 'aaaaaaaaaaaaaaa');

INSERT IGNORE INTO services (id, date, route, driver, plate, departure_time, status) VALUES
('P04345', '2025-05-14', 'Afe Surquillo - Ancon - Afe Surquillo', 'DIEGO ENRIQUE QUISPE AGUILAR', 'AJY-748', '06:00', 'COMPLETED'),
('P04346', '2025-05-14', 'Afe Surquillo - Afe Zapallal - Puente Piedra - Afe Surquillo', 'LENIN CARRASCO ACUÑA', 'DOP-704', '06:00', 'COMPLETED'),
('P04339', '2025-05-14', 'Afe Surquillo - La Molina - Los Olivos - Av. Abancay - Cercado de Lima - Jesus María - Afe Surquillo', 'SERGIO CASAS RIOS', 'ALP-934', '06:00', 'COMPLETED'),
('P04347', '2025-05-14', 'Afe Surquillo - Breña - Afe Surquillo', 'WILBER JESUS POMA CONDORI', 'C3I-795', '07:00', 'IN_PROGRESS'),
('P04340', '2025-05-14', 'Afe Surquillo - Miraflores - Estadio Surquillo - Afe Surquillo - Av. Abancay - Afe Surquillo', 'CARLOS ALBERTO MAGNO TORRES', 'ALP-807', '07:30', 'IN_PROGRESS'),
('P04342', '2025-05-14', 'Afe Surquillo - La Victoria - Av. Argentina - Afe Surquillo', 'ALAIN CALDERON FLORES', 'AJX-937', '08:00', 'IN_PROGRESS'),
('P04348', '2025-05-14', 'Afe Surquillo - Breña - Afe Surquillo', 'CLIDER MARCIAL CIPRIANO CASIO', 'ADS-936', '08:00', 'PENDING'),
('P04341', '2025-05-14', 'Afe Surquillo - La Victoria - Afe Surquillo', 'RICK KEVIN CORDOVA AGUILAR', 'D7L-789', '08:00', 'IN_PROGRESS'),
('P04343', '2025-05-14', 'Afe Surquillo - Av. Nicolas de Pierola (Gerencia General) - Av. Paseo de la Republica (Palacio de Justicia) - Afe Surquillo', 'JESUS MAXIMO SHERON FLORES', 'ALP-849', '14:00', 'IN_PROGRESS'),
('P04337', '2025-05-14', 'Afe Surquillo - La Victoria - Aeropuerto - Afe Surquillo', 'JOSE DAVID DAVILA CUBAS', 'D7L-789', '17:30', 'COMPLETED'),
('P04344', '2025-05-14', 'Afe Surquillo - La Victoria - Aeropuerto - Afe Surquillo', 'JOSE DAVID DAVILA CUBAS', 'D7L-726', '17:30', 'PENDING'),
('P04349', '2025-05-15', 'Afe Guardia Civil - Afe Surquillo - Lima - Afe Guardia Civil', 'MOISES ISRAEL CHAVEZ VELASQUEZ', '2306ec', '08:00', 'PENDING');

INSERT IGNORE INTO fuel_records_summaries (id, service_id, total_records, initial_date, final_date, total_fuel, plates) VALUES
('fcea', 'P04340', 6, '2025-05-14 07:39:00', '2025-05-14 11:54:00', 0.00, 'ALP-807'),
('c0d1', 'P04345', 6, '2025-05-14 05:50:00', '2025-05-14 11:53:00', 11.43, 'AJY-748'),
('d422', 'P04342', 4, '2025-05-14 09:21:00', '2025-05-14 11:38:00', 0.00, 'AJX-937'),
('e97c', 'P04343', 1, '2025-05-14 11:37:00', '2025-05-14 11:37:00', 0.00, 'ALP-849'),
('c656', 'P04339', 6, '2025-05-14 05:46:00', '2025-05-14 11:32:00', 0.00, 'ALP-934'),
('41cf', 'P04346', 3, '2025-05-14 06:05:00', '2025-05-14 11:26:00', 11.43, 'DOP-704'),
('7729', 'P04341', 2, '2025-05-14 09:01:00', '2025-05-14 09:46:00', 0.00, 'D7L-789'),
('ec85', 'P04347', 3, '2025-05-14 06:57:00', '2025-05-14 08:08:00', 5.00, 'C3I-795'),
('d57f', 'P04337', 5, '2025-05-13 17:39:00', '2025-05-14 05:32:00', 0.00, 'D7L-789'),
('8e2d', 'P04336', 2, '2025-05-13 08:56:00', '2025-05-13 18:35:00', 0.00, 'BMU-824');

INSERT IGNORE INTO schedules (id, schedule_date, service_date, origin, destination, driver, plate, departure_time, final_cost) VALUES
('P04349', '2025-05-14', '2025-05-15', 'Afe surquillo', 'Afe Guardia Civil - Afe Surquillo - Lima - Afe Guardia Civil', 'MOISES ISRAEL CHAVEZ VELASQUEZ', '2306ec', '08:00', 0.00),
('P04339', '2025-05-13', '2025-05-14', 'Afe surquillo', 'Afe Surquillo - La Molina - Los Olivos - Av. Abancay - Cercado de Lima - Jesus María - Afe Surquillo', 'SERGIO CASAS RIOS', 'ALP-934', '06:00', 0.00),
('P04340', '2025-05-13', '2025-05-14', 'Afe surquillo', 'Afe Surquillo - Miraflores - Estadio Surquillo - Afe Surquillo - Av. Abancay - Afe Surquillo', 'CARLOS ALBERTO MAGNO TORRES', 'ALP-807', '07:30', 90.00),
('P04341', '2025-05-13', '2025-05-14', 'Afe surquillo', 'Afe Surquillo - La Victoria - Afe Surquillo', 'RICK KEVIN CORDOVA AGUILAR', 'D7L-789', '08:00', 90.00),
('P04342', '2025-05-13', '2025-05-14', 'Afe surquillo', 'Afe Surquillo - La Victoria - Av. Argentina - Afe Surquillo', 'ALAIN CALDERON FLORES', 'AJX-937', '08:00', 0.00),
('P04343', '2025-05-13', '2025-05-14', 'Afe surquillo', 'Afe Surquillo - Av. Nicolas de Pierola (Gerencia General) - Av. Paseo de la Republica (Palacio de Justicia) - Afe Surquillo', 'JESUS MAXIMO SHERON FLORES', 'ALP-849', '14:00', 90.00),
('P04344', '2025-05-13', '2025-05-14', 'Afe surquillo', 'Afe Surquillo - La Victoria - Aeropuerto - Afe Surquillo', 'JOSE DAVID DAVILA CUBAS', 'D7L-726', '17:30', 0.00),
('P04345', '2025-05-13', '2025-05-14', 'Afe surquillo', 'Afe Surquillo - Ancon - Afe Surquillo', 'DIEGO ENRIQUE QUISPE AGUILAR', 'AJY-748', '06:00', 150.00),
('P04346', '2025-05-13', '2025-05-14', 'Afe surquillo', 'Afe Surquillo - Afe Zapallal - Puente Piedra - Afe Surquillo', 'LENIN CARRASCO ACUÑA', 'DOP-704', '06:00', 150.00),
('P04347', '2025-05-13', '2025-05-14', 'Afe surquillo', 'Afe Surquillo - Breña - Afe Surquillo', 'WILBER JESUS POMA CONDORI', 'C3I-795', '07:00', 90.00);

INSERT IGNORE INTO users (id, name, dni, level, created_at) VALUES
('1', 'ALAIN CALDERON FLORES', '71914672', 'Conductor', '2025-04-15 08:41:00'),
('2', 'CARLOS ALBERTO MAGNO TORRES', '10027210', 'Conductor', '2025-03-29 12:02:00'),
('3', 'CLIDER MARCIAL CIPRIANO CASIO', '44107445', 'Conductor', '2025-03-29 12:02:00'),
('4', 'DIEGO ENRIQUE QUISPE AGUILAR', '71495691', 'Conductor', '2025-03-29 12:02:00'),
('5', 'JESUS MAXIMO SHERON FLORES', '07464472', 'Conductor', '2025-03-29 12:02:00'),
('6', 'JOSE ARTEMIO SULCA VILLAR', '07539133', 'Conductor', '2025-03-29 12:02:00'),
('7', 'JOSE DAVID DAVILA CUBAS', '45495272', 'Conductor', '2025-03-29 12:02:00'),
('8', 'LENIN CARRASCO ACUÑA', '46693171', 'Conductor', '2025-03-29 12:02:00'),
('9', 'OSCAR MIGUEL CAJAHUANCA VIVANCO', '10646997', 'Conductor', '2025-03-29 12:02:00'),
('10', 'RICK KEVIN CORDOVA AGUILAR', '74755634', 'Conductor', '2025-04-24 15:04:00'),
('11', 'SERGIO CASAS RIOS', '08654512', 'Conductor', '2025-03-29 12:02:00'),
('12', 'WILBER JESUS POMA CONDORI', '46307573', 'Conductor', '2025-03-29 12:02:00'),
('13', 'YSIDRO ANDRES RUBIO PEREZ', '16691234', 'Conductor', '2025-03-29 12:02:00'),
('14', 'Administrador Sistema', '70068162', 'Administrador', '2025-03-29 11:37:00');