# Users App Android

Este es el repositorio del proyecto de la prueba técnica para desarrolladores de aplicaciones android. La aplicación se desarrolló para Android utilizando el lenguaje de programación Kotlin y el IDE Android Studio. 

## **Descripción del proyecto**

El proyecto consiste en una aplicación que muestra un listado de usuarios con su información básica, como nombre, email, teléfono y sitio web. La aplicación consume la información de la siguiente API: [https://jsonplaceholder.typicode.com/users](https://jsonplaceholder.typicode.com/users)

## **Estructura del proyecto**

El proyecto sigue una estructura basada en la arquitectura de Android recomendada por Google, la cual incluye el patrón de arquitectura MVVM y la arquitectura limpia (Clean Architecture) para separar las responsabilidades en capas. Además, se utiliza viewModel, LiveData y ViewBindin para la construcción de la interfaz de usuario y Retrofit para la comunicación con la API.

La estructura del proyecto se organiza en diferentes paquetes que corresponden a las distintas capas y componentes del proyecto:

- **`data`**: Contiene las fuentes de datos de la aplicación, como la interfaz que define el repositorio, las implementaciones de los datos remotos y locales, y los modelos de datos que se utilizan para la comunicación con la API.
- **`domain`**: Contiene la capa de dominio de la aplicación, que define los casos de uso y los modelos de negocio de la aplicación.
- **`presentation`**: Contiene la capa de presentación de la aplicación, que incluye los componentes de la interfaz de usuario y la lógica de presentación que interactúa con la capa de dominio.

Cada una de estas capas se separa en subpaquetes que contienen los distintos componentes y módulos de la aplicación, siguiendo los principios de separación de responsabilidades y cohesión.

Además, se utiliza la herramienta de inyección de dependencias Hilt para la gestión de dependencias en la aplicación, lo que permite una mejor organización y facilidad de mantenimiento.

La estructura final del proyecto queda organizada de la siguiente manera:

```

├── data
│   ├── api
│   └── repository
├── domain
│   ├── model
│   └── usecase
├── di
├── presentatio
├── utils

```

En el paquete **`data`**, se encuentra la capa de datos de la aplicación, que contiene los siguientes subpaquetes:

- **`api`**: Contiene las interfaces y clases necesarias para realizar la comunicación con la API utilizando Retrofit.
- **`repository`**: Contiene la interfaz que define el repositorio y su implementación, que se encarga de coordinar los datos remotos y locales y proporcionarlos a la capa de dominio.

En el paquete **`domain`**, se encuentra la capa de dominio de la aplicación, que contiene los siguientes subpaquetes:

- **`model`**: Contiene los modelos de negocio de la aplicación, que representan la información que se utiliza en la aplicación.
- **`usecase`**: Contiene los casos de uso de la aplicación, que son las acciones que pueden llevarse a cabo en la aplicación y que definen la lógica de negocio de la misma.

En el paquete **`di`**: Contiene los módulos de inyección de dependencias utilizando Hilt.

En el paquete **`presentation`**, se encuentra la capa de presentación de la aplicación, que contiene la vista principal y viewModel.

En el paquete **`utils`**, contiene clases de utilidad y extensiones que se utilizan en diferentes partes de la aplicación.

Cada subpaquete contiene diferentes clases y componentes que se encargan de realizar distintas tareas dentro de la aplicación.

## **Uso del proyecto**

Para utilizar el proyecto, se puede clonar este repositorio en su máquina local y abrir el proyecto en Android Studio. Luego, se puede ejecutar la aplicación en un emulador o dispositivo físico con Android 5.0 o superior.

## **Contribuciones**

Las contribuciones son bienvenidas. Si desea sugerir mejoras o reportar problemas, puede crear un issue en este repositorio.