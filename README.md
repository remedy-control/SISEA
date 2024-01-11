># SISEA

## Descripción del proyecto

Este proyecto tiene como finalidad de tener registro de las localidades de un usuario.

- En el formulario `AMX:SISEA:GeneraFolioInterno` se agrega el numero de usuario para conseguir sus localidades.
- Con esa información se almacena en el formulario `AMX:SISEA:ConsumeLocalidadesRC`.

## Estado del proyecto

Este proyecto actualmente se encuentra en uso y está desplegado en los 2 ambientes (desarrollo y QA).

## Requerimientos

Se recomienda encarecidamente respetar estos puntos para poder usar la aplicación de forma correcta:

-   Tener instalado Java 1.8
-   Hacer deploy en un servidor Tomcat 8 o superior

## Ejecutar

Divido que el programa se ejecuta por factores externos no se puede ejecutar de manera local.

## Despliegue en el servidor

Para desplegar la aplicación, se requiere colocar el archivo `SISEA.war` en el servidor de aplicaciones, siguiendo estos pasos:

1.  Accede al servidor de aplicaciones.
2.  Navega hasta la ubicación `/webapps8` del servidor.
3.  En la anterior ruta mencionada, coloca el arhcivo `SISEA.war`, ubicado en la ruta `/SISEA/dist/SISEA.war` del proyecto ya ejecutado.
4.  Una vez que hayas colocado el archivo en el servidor, el servidor de aplicaciones automáticamente desplegará el proyecto. Esto resultará en la creación de un directorio dedicado al proyecto en la siguiente ubicación: `/webapps8/SISEA`.

