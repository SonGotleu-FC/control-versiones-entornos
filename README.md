# control-versiones-entornos

Actividad evaluable de Entornos de Desarrollo: Control de Versiones.

Calculadora de numeros enteros de hasta 5 digitos [-99999..99999] con cuatro operaciones: suma, resta, multiplicacion y potencia.

## Estructura de ramas

- main: solo actualizaciones de comentarios (README) y los merges de las otras ramas.
- backend: solo archivos .java (Calculadora.java).
- frontend: solo archivos .html (index.html).

## Como ejecutarlo

- Backend: javac Calculadora.java y despues java Calculadora
- Frontend: abrir index.html en el navegador (valida y calcula en el propio navegador con las mismas reglas).

## Como publicar un repositorio en GitHub

1. Crear un repositorio nuevo en GitHub (publico, con README).
2. En local: git init, anadir los archivos, hacer commit y enlazar con el remoto.
3. Subir con git push -u origin main (y cada rama con git push -u origin nombre-rama).

## Comandos en orden cronologico

Nota: se hizo desde la web de GitHub. Los comandos son los equivalentes en terminal.

1. Crear el repositorio con README (rama main, commit inicial "Initial commit"):

       git init
       git add README.md
       git commit -m "Initial commit"
       git branch -M main
       git remote add origin https://github.com/SonGotleu-FC/control-versiones-entornos.git
       git push -u origin main

2. Rama backend con Calculadora.java:

       git checkout -b backend
       git add Calculadora.java
       git commit -m "Calculadora.java a backend"
       git push -u origin backend

3. Rama frontend con index.html (creada desde main):

       git checkout main
       git checkout -b frontend
       git add index.html
       git commit -m "index.html a frontend"
       git push -u origin frontend

4. Merge de frontend en main (pull request #1, merge commit):

       git checkout main
       git merge --no-ff frontend
       git push origin main

5. Merge de backend en main (pull request #2, merge commit):

       git merge --no-ff backend
       git push origin main

6. Actualizar este README con los comandos:

       git add README.md
       git commit -m "Actualizar README con los comandos"
       git push origin main

Hecho desde la web, le he pedido los comandos equivalentes a Claude.
