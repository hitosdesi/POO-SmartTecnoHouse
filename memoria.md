# Memoria Técnica — Smart TecnoHouse SA
## Programación Orientada a Objetos · UTAMED

**Autor:** Desiderio Hitos Padial  
**Repositorio:** https://github.com/hitosdesi/SmartTecnoHouse-POO  
**Fecha:** Mayo 2025

---

## 1. Decisiones de Diseño y Principios SOLID

### Jerarquía de clases

El sistema se estructura en dos jerarquías que convergen en IDispositivo:

- IDispositivo
  - Sensor (abstract): SensorTemperatura, SensorLuz, SensorPresencia, SensorHumedad (AMPLIACIÓN)
  - Actuador (abstract): Bombilla, Ventilador, Persiana (AMPLIACIÓN)

### Principios SOLID

- S: GestorJSON solo serializa; Casa gestiona dispositivos; cada Regla encapsula una lógica.
- O: SensorHumedad y Persiana se añadieron sin modificar ninguna clase existente.
- L: Cualquier Sensor o Actuador concreto sustituye a su clase abstracta sin romper el sistema.
- I: IDispositivo define solo getID, getNombre y getEstadoActual.
- D: El Controlador depende de abstracciones Sensor, Actuador y Regla, no de implementaciones.

---

## 2. Patrones de Diseño

### 2.1 Patrón Strategy

Interfaz Regla con método aplicar(List<Sensor>, List<Actuador>).
Implementaciones: ReglaVentilacion (temp > 26 grados -> Ventilador HIGH) y ReglaIluminacion (luz < 200 lux + presencia -> Bombilla ON).
Casa itera la lista de reglas llamando a aplicar() en cada una sin conocer la implementación concreta.

### 2.2 Patrón MVC

- Modelo (modelo.*): Casa, Sensor, Actuador, Regla, GestorJSON. Sin imports de Swing.
- Vista (vista.*): VentanaPrincipal. Solo pinta datos y captura eventos.
- Controlador (controlador.SmartTecnoHouseControlador): media entre Vista y Modelo.

### 2.3 Patrón Singleton

Casa usa constructor privado e getInstance() sincronizado para garantizar una única instancia.

---

## 3. Ampliaciones

### SensorHumedad
- ID: hum | Unidad: %HR | Rango: 20-90%
- Añadido extendiendo Sensor sin modificar ninguna clase existente.

### Persiana
- ID: blind | Acciones: ABRIR, MEDIO, CERRAR
- Incorporado a la jerarquía de Actuador sin modificar Bombilla ni Ventilador.

---

## 4. Manual de Usuario

Arrancar: mvn clean package && java -jar target/SmartTecnoHouse-1.0-SNAPSHOT.jar

- Panel Sensores: muestra lecturas en tiempo real. Boton Actualizar para refrescar.
- Panel Actuadores: botones de control manual por dispositivo.
- Panel Reglas: activar reglas y pulsar Aplicar Reglas para ejecutar automatizacion.
- Guardar Estado: persiste el estado en data/estado.json automaticamente al cerrar.

---

## 5. Persistencia JSON

GestorJSON usa Gson para guardar y cargar data/estado.json con el estado de los actuadores.

---

## 6. Control de versiones

- main: codigo estable y entregable.
- develop: rama de desarrollo fusionada a main via Pull Request.

