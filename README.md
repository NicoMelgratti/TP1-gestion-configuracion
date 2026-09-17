# Trabajo Practico Integrador N° 1 - Sistemas de Gestion de la Configuracion

**Materia:** Ingenieria y Calidad del Software  
**Institucion:** Universidad Tecnologica Nacional - Facultad Regional Santa Fe (UTN FRSF)  
**Ano:** 2026  

---

## Integrantes del Grupo
- **Bortoli, Antonio** (Usuario GitHub: `@AntonioBortoli`)
- **Loza, Franco** (Usuario GitHub: `@Franco-Loza`)
- **Melgratti, Nicolas** (Usuario GitHub: `@NicoMelgratti`)
- **Soltermann, Francisco** (Usuario GitHub: `@FranciscoSoltermann`)

---

## Descripcion del Sistema
Plataforma logistica simplificada para e-Commerce dividida en dos modulos principales:
1. **WMS (Warehouse Management System):** Control de stock, recepcion de productos y preparacion de pedidos (picking y packing).
2. **TMS (Transportation Management System):** Creacion de envios, actualizacion de estados y tracking de despacho.

---

## Tecnologias y Ejecucion
- **Lenguaje:** Java 17
- **Gestor de dependencias:** Maven
- **Pruebas automatizadas:** JUnit 5

```bash
# Compilar y ejecutar pruebas unitarias
mvn clean test

# Ejecutar el programa principal
mvn compile exec:java -Dexec.mainClass="com.utn.logistics.App"
```

---

## Flujo de Ramificacion (GitFlow)
- `main`: Rama productiva. Contiene versiones estables marcadas con tags (`v1.0.0`, `v1.0.1`, etc.).
- `develop`: Rama principal de integracion y desarrollo.
- `feature/*`: Ramas para el desarrollo de nuevas funcionalidades que se integran a `develop` mediante Pull Requests.
- `release/*`: Ramas de preparacion de nuevas versiones hacia produccion.
- `hotfix/*`: Ramas para la correccion urgente de errores detectados en `main`.

---

## Respuestas al Cuestionario del Trabajo Practico

### 1. ¿Como hacemos para no subir cambios de configuraciones locales? (Punto 7.b)
Para evitar subir configuraciones locales de los desarrolladores se utiliza el archivo `.gitignore` en la raiz del repositorio. En este archivo se configuran las exclusiones de:
- Carpetas y archivos de configuracion de IDEs (`.idea/`, `.vscode/`, `*.iml`, `.settings/`).
- Carpetas de compilacion y binarios (`target/`, `*.class`).
- Archivos de configuracion local y variables de entorno (`.env`, `*.local.properties`, `*.log`).

Esto asegura que el repositorio solo contenga codigo fuente y dependencias compartidas, sin afectar la configuracion particular de cada maquina.

---

### 2. ¿Que documentarian en el README del repositorio? (Punto 8.a)
En el archivo `README.md` se debe documentar toda la informacion basica y necesaria para que cualquier desarrollador pueda entender, compilar y contribuir al proyecto:
- **Descripcion del proyecto:** Explicacion general del problema y alcance de los modulos del sistema (WMS y TMS).
- **Requisitos de entorno:** Versiones necesarias de Java, Maven u otras herramientas.
- **Instrucciones de instalacion y ejecucion:** Comandos claros para compilar el codigo y correr los tests.
- **Estrategia de ramas (GitFlow):** Descripcion del modelo de branching utilizado en el equipo.
- **Integracion Continua (CI):** Como funciona el pipeline de pruebas automaticas en GitHub Actions.
- **Integrantes del equipo:** Nombre, apellido y usuario de GitHub de cada colaborador.

---

### 3. Si un externo realiza una modificacion (PR), ¿que datos le pediria que complete y que nos ofrece GitHub para ayudarnos? (Punto 8.b)

#### A. Datos solicitados en el Pull Request:
1. **Tipo de cambio:** Identificar si se trata de una nueva funcionalidad, correccion de error, refactor o documentacion.
2. **Descripcion y justificacion:** Explicar que problema resuelve el cambio y los motivos por los cuales se eligio esa implementacion.
3. **Referencia al requerimiento o issue:** Enlace o numero de ticket correspondiente (ej. `Closes #10`).
4. **Plan de pruebas y resultados:** Indicar las pruebas unitarias y manuales realizadas para validar que el cambio funciona y no genera regresiones.
5. **Checklist de verificacion:** Confirmar que el codigo compila, pasa las pruebas y no contiene credenciales ni archivos locales.

#### B. Herramientas que ofrece GitHub para gestionarlo:
- **Pull Request Template (`.github/PULL_REQUEST_TEMPLATE.md`):** Despliega automaticamente un formulario estructurado cuando alguien abre un PR, obligando a completar los datos requeridos.
- **CODEOWNERS (`.github/CODEOWNERS`):** Asigna de forma automatica a los responsables correspondientes del equipo como revisores obligatorios segun los archivos modificados.
- **GitHub Actions (CI Pipeline):** Ejecuta de manera automatica la compilacion y los tests unitarios en cada PR para verificar que el build sea exitoso antes de permitir el merge.
- **Branch Protection Rules:** Reglas de proteccion configurables en GitHub para exigir aprobacion de revisores y paso exitoso del pipeline de CI antes de mergear a `main` o `develop`.
