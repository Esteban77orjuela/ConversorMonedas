# Conversor de Monedas en Java

Este proyecto es un Conversor de Monedas hecho en Java que usa la API de ExchangeRate para tener tasas de cambio al tiempo inmediato.

## Características

- Obtiene tasas de cambio en tiempo real de la API.
- Permite la conversión entre 6 monedas diferentes que son: ARS, BOB, BRL, CLP, COP y USD.
- Interfaz de usuario sencilla a través de la consola.
- Utilizando Programación Orientada a Objetos (POO).

## Requisitos

- Java JDK 11 o superior
- Biblioteca Gson 2.10.1 o superior
- Una clave de API de ExchangeRate-API

## Configuración

1. Se clona este repositorio.
2. Se obtiene una clave de API de [ExchangeRate-API](https://www.exchangerate-api.com/).
3. Se reemplaza "TU_API_KEY_AQUI" en el código con tu clave de API real.
4. Se asegura de tener la biblioteca Gson en tu proyecto.

## Uso

1. Se compila y se ejecuta la clase `ConversorMonedas`.
2. Se debe sigue las instrucciones que se muestran en la consola para seleccionar las monedas y la cantidad a convertir.

## Estructura del Proyecto

- `ConversorMonedas.java`: Contiene toda la lógica del conversor de monedas.

## Contribuciones

Las contribuciones son aceptadas. Por favor, abre un issue para debatir sobre los cambios propuestos antes de realizar un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.
