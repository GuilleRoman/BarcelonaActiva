create database queries_mysql;
use queries_mysql;
create table DEPARTAMENTOS (
   DEPTNO               int                  not null,
   DNAME                varchar(15)          not null,
   LOC                  varchar(10)          not null,
   constraint PK_DEPARTAMENTOS primary key nonclustered (DEPTNO)
);

create table EMPLEADOS (
   EMPNO                int                  not null,
   DEPTNO               int                  null,
   ENAME                varchar(10)          not null,
   JOB                  varchar(20)          not null,
   MGR                  int                  null,
   HIREDATE             datetime             not null,
   SAL                  int                  not null,
   COMM                 int                  null,
   constraint PK_EMPLEADOS primary key nonclustered (EMPNO)
);

create index TIENE_FK on EMPLEADOS (
DEPTNO ASC
);

alter table EMPLEADOS
   add constraint FK_EMPLEADO_TIENE_DEPARTAM foreign key (DEPTNO)
      references DEPARTAMENTOS (DEPTNO);
      
insert into departamentos values 
(10, 'ACCOUNTING', 'NEW YORK'),
(20, 'RESEARCH', 'DALLAS'),
(30, 'SALES', 'CHICAGO'),
(40, 'OPERATIONS','BOSTON');

insert into empleados (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) values
(7369, 'SMITH', 'CLERK', 7902, '1980/12/17', 800, null, 20),
(7499, 'ALLEN', 'SALESMAN', 7698, '1981/02/20', 1600, 300, 30),
(7521, 'WARD', 'SALESMAN', 7698, '1981/02/22', 1250, 500, 30),
(7566, 'JONES', 'MANAGER', 7839, '1981/04/02', 2975, null, 20),
(7654, 'MARTIN', 'SALESMAN', 7698, '1981/09/28', 1250, 1400, 30),
(7698, 'BLAKE', 'MANAGER', 7839, '1981/05/01', 2850, null, 30),
(7782, 'CLARK', 'MANAGER', 7839, '1981/06/09', 2450, null, 10),
(7788, 'SCOTT', 'ANALYST', 7566, '1982/12/09', 3000, null, 20),
(7839, 'KING', 'PRESIDENT', null, '1981/11/17', 5000, null, 10),
(7844, 'TURNER', 'SALESMAN', 7698, '1981/09/08', 1500, 0, 30),
(7876, 'ADAMS', 'CLERK', 7788, '1983/01/12', 1100, null, 20),
(7900, 'JAMES', 'CLERK', 7698, '1981/12/03', 950, null, 30),
(7902, 'FORD', 'ANALYST', 7566, '1981/12/03', 3000, null, 20),
(7934, 'MILLER', 'CLERK', 7782, '1982/01/23', 1300, null, 10);

/*
EJERCICIOS
*/
-- 1) Obtener todos los datos de todos los empleados
SELECT * FROM empleados;
-- 2)Obtener todos los datos de todos los departamentos.
SELECT * FROM departamentos;
-- 3) Obtener todos los datos de los administrativos (su trabajo es, en ingles, 'CLERK').
SELECT * FROM empleados WHERE JOB LIKE 'CLERK';
-- 4) Idem, pero ordenado por el nombre.
SELECT * FROM empleados WHERE JOB LIKE 'CLERK' ORDER BY ENAME;
-- 5) Obten el mismo resultado de la pregunta anterior, pero ahora ordenando sólo por deptno en sentido descendente
SELECT * FROM empleados WHERE JOB LIKE 'CLERK' ORDER BY DEPTNO DESC;
-- 6) Obten el (codigo), nombre y salario de los empleados.
SELECT EMPNO, ENAME, SAL FROM empleados;
-- 7) Lista los nombres de todos los departamentos.
SELECT DISTINCT DNAME FROM departamentos;
-- 8) Idem, pero ordenandolos por nombre.
SELECT DISTINCT DNAME FROM departamentos ORDER BY DNAME;
-- 9) Idem, pero ordenandolo por la ciudad (no se debe seleccionar la ciudad en el resultado).
SELECT DISTINCT DNAME FROM departamentos ORDER BY LOC;
-- 10) Idem, pero el resultado debe mostrarse ordenado por la ciudad en orden inverso.
SELECT DISTINCT DNAME FROM departamentos ORDER BY LOC desc;
-- 11) Obtener el nombre y empleo de todos los empleados, ordenado por salario.
SELECT ENAME, JOB FROM empleados ORDER BY SAL;
-- 12) Obtener el nombre y empleo de todos los empleados, ordenado primero por su trabajo y luego por su salario.
SELECT ENAME, JOB FROM empleados ORDER BY JOB, SAL;
-- 13) Idem, pero ordenando inversamente por empleo y normalmente por salario.
SELECT ENAME, JOB FROM empleados ORDER BY JOB desc, SAL;
-- 14) Obten los salarios y las comisiones de los empleados del departamento 30.
SELECT SAL, COMM FROM empleados WHERE DEPTNO = 30;
-- 15) Idem, pero ordenado por comision.
SELECT SAL, COMM FROM empleados WHERE DEPTNO = 30 ORDER BY COMM;
-- 16) (a) Obten las comisiones de todos los empleados.
SELECT COMM FROM empleados;
-- 16) (b) Obten las comisiones de los empleados de forma que no se repitan.
SELECT DISTINCT COMM FROM empleados;
-- 17) Obten el nombre de empleado y su comision SIN FILAS repetidas.
SELECT  DISTINCTROW ENAME, COMM FROM empleados ORDER BY ENAME;
-- 18) Obten los nombres de los empleados y sus salarios, de forma que no se repitan filas.
SELECT DISTINCTROW ENAME, SAL FROM empleados ORDER BY ENAME;
-- 19) Obten las comisiones de los empleados y sus Obtens de departamento, de forma que no serepitan filas.
SELECT DISTINCTROW COMM, DEPTNO FROM empleados ORDER BY DEPTNO;
-- 20) Obten los nuevos salarios de los empleados del departamento 30, que resultaran 
-- de sumar a su salario una gratificacion de 1000. Muestra tambien los nombres de los empleados.
SELECT ENAME, SAL+1000 FROM empleados;
-- 21) Lo mismo que la anterior, pero mostrando tambien su salario original, y 
-- haz que la columna que almacena el nuevo salario se denomine NUEVO SALARIO.
SELECT ENAME, SAL, SAL+1000 AS 'Nuevo salario' FROM empleados;
-- 22) Halla los empleados que tienen una comision superior a la mitad de su salario.
SELECT ENAME FROM empleados WHERE COMM > SAL/2;
-- 23) Halla los empleados que no tienen comision, o que la tengan menor o igual que el 25% de su salario.
SELECT ENAME FROM empleados WHERE COMM IS NULL || COMM <= (SAL*25)/100;
-- 24) Obten una lista de nombres de empleados y sus salarios, de forma que en 
-- la salida aparezca en todas las filas \Nombre:" y \Salario:" antes del respectivo campo.
SELECT CONCAT('Nombre: ',ENAME, '   Salario: ', SAL) FROM empleados;
-- 25) Hallar el codigo, salario y comision de los empleados cuyo codigo sea mayor que 7500.
SELECT EMPNO, SAL, COMM FROM empleados WHERE EMPNO > 7500;
-- 26) Obten todos los datos de los empleados que esten a partir de la J, inclusive.
-- NOTA: Para ello usa la funcion left de PLMySql   TERMINAR CORRECTAMENTE DESPUÉS
SELECT * 
	FROM empleados  
    ORDER BY 
    CASE
    WHEN
		LEFT(ENAME, 1) = 'J'
        THEN 1
	WHEN 
		LEFT(ENAME, 1) = 'K'
        THEN 1
   WHEN 
		LEFT(ENAME, 1) = 'l'
        THEN 1     
	ELSE 2
    END;
    SELECT * FROM empleados GROUP BY ENAME HAVING LEFT(ENAME, 1) = '[J-Z]' ORDER BY ENAME;
				
-- 27) Obten el salario, comision y salario total (salario+comision) de los empleados 
-- con comision, ordenando el resultado por numero de empleado.
SELECT SAL, COMM, SAL+COMM AS 'SALARIO TOTAL' FROM empleados WHERE COMM IS NOT NULL ORDER BY EMPNO;
-- 28) Lista la misma informacion, pero para los empleados que no tienen comision.
SELECT SAL, COMM, SAL+COMM AS 'SALARIO TOTAL' FROM empleados WHERE COMM IS NULL ORDER BY EMPNO;
-- 29) Muestra el nombre de los empleados que, teniendo un salario superior 
-- a 1000, tengan como jefe al empleado cuyo codigo es 7698.
SELECT ENAME FROM empleados WHERE SAL > 1000 AND MGR = 7698;
-- 30) Muestra el nombre de los empleados que, teniendo un salario inferior 
-- a 1000, no tengan como jefe al empleado cuyo codigo es 7698. 
SELECT ENAME FROM empleados WHERE SAL < 1000 AND MGR != 7698;
-- 31) Indica para cada empleado el porcentaje que supone su comision sobre su 
-- salario, ordenando el resultado por el nombre del mismo.
SELECT ENAME, COMM/SAL*100 AS 'Porcentaje de la comisión' FROM empleados ORDER BY ENAME;
-- 32) Hallar los empleados del departamento 10 cuyo nombre no contiene la cadena LA.
SELECT ENAME FROM empleados WHERE DEPTNO =10 AND ENAME NOT LIKE'%LA%';
-- 33) Obten los empleados que no son supervisados por ningun otro.
SELECT ENAME FROM EMPLEADOS WHERE MGR IS NULL;
-- 34) Obten los nombres de los departamentos que no sean Ventas (SALES) ni 
-- investigacion (RESEARCH). Ordena el resultado por la localidad del departamento.
SELECT DNAME FROM departamentos WHERE DNAME NOT LIKE'%SALES%' AND DNAME NOT LIKE'%RESEARCH%' ORDER BY LOC;
-- 35) Deseamos conocer el nombre de los empleados y el codigo del departamento 
-- de los administrativos(CLERK) que no trabajan en el departamento 10, y cuyo 
-- salario es superior a 800, ordenado por fecha de contratacion.
SELECT ENAME, DEPTNO FROM empleados INNER JOIN departamentos USING(DEPTNO) WHERE JOB LIKE 'CLERK' AND DEPTNO != 10 AND SAL > 800 ORDER BY HIREDATE;
-- 36) Para los empleados que tengan comision, obten sus nombres y el cociente entre 
-- su salario y su comision (excepto cuando la comision sea cero), ordenando el resultado por nombre.
SELECT ENAME, SAL/COMM FROM empleados WHERE COMM IS NOT NULL AND COMM > 0 ORDER BY ENAME;
-- 37) Lista toda la informacion sobre los empleados cuyo nombre completo tenga exactamente 5 caracteres.
SELECT * FROM empleados WHERE CHAR_LENGTH(ename) =5;
-- 38) Lo mismo, pero para los empleados cuyo nombre tenga al menos cinco letras.
SELECT * FROM empleados WHERE CHAR_LENGTH(ename)  >=5;
-- 39) Halla los datos de los empleados que, o bien su nombre empieza por A y su 
-- salario es superior a 1000, o bien reciben comision y trabajan en el departamento 30.
SELECT * FROM empleados WHERE (ENAME LIKE 'A%' AND SAL > 1000) OR (COMM IS NOT NULL AND DEPTNO =30);
-- 40) Halla el nombre, el salario y el sueldo total de todos los empleados, ordenando 
-- el resultado primero por salario y luego por el sueldo total. En el caso de que no 
-- tenga comision, el sueldo total debe reflejar solo el salario.
SELECT ENAME, SAL,
CASE 
WHEN COMM IS NULL
THEN SAL
ELSE SAL+COMM 
END AS 'SALARIO_TOTAL'
FROM empleados ORDER BY SAL, salario_total ;
-- 41) Obten el nombre, salario y la comision de los empleados que perciben 
-- un salario que esta entre la mitad de la comision y la propia comision.
SELECT ENAME, SAL, COMM FROM empleados WHERE SAL BETWEEN COMM/2 AND COMM;
-- 42) Obten el nombre, salario y la comision de los empleados que perciben 
-- un salario complementario al caso 41: que sea superior a la comision o inferior a la mitad de la comision.
SELECT ENAME, SAL, COMM FROM empleados WHERE SAL > COMM OR SAL < COMM/2;
-- 43) Lista los nombres y empleos de aquellos empleados cuyo empleo acaba 
-- en MAN y cuyo nombre empieza por A.
SELECT ENAME, JOB FROM empleados WHERE JOB LIKE '%MAN' AND ENAME LIKE 'A%';
-- 44) Intenta resolver la pregunta anterior con un predicado simple, es decir, 
-- de forma que en la clausula WHERE no haya conectores logicos como AND, OR, etc. 
-- Si ayuda a resolver la pregunta, se puede suponer que el nombre del empleado tiene al menos cinco letras.
SELECT ENAME, JOB FROM empleados WHERE JOB LIKE '%MAN' HAVING length(ENAME)=5;
-- 45) Halla los nombres de los empleados cuyo nombre tiene como maximo cinco caracteres.
SELECT ENAME FROM EMPLEADOS WHERE length(ENAME)<=5;
-- 46) Suponiendo que el a~no proximo la subida del sueldo total de cada empleado sera del 60 %, 
-- y el siguiente del 70 %, halla los nombres y el salario total actual, del a~no proximo y del 
-- siguiente, de cada empleado. Indique ademas con SI o NO, si el empleado tiene comision. 
SELECT ENAME, SAL,
CASE
	WHEN COMM IS NULL
    THEN SAL
    ELSE SAL+COMM
    END AS 'SALARIO TOTAL',
CASE COMM
	WHEN COMM IS NULL
		THEN 'NO'
		ELSE 'SI'
END AS '¿TIENE COMISIÓN?',
 ROUND((60*SAL)/100+SAL, 2) AS 'SUELDO_2022', ROUND((70*((60*SAL)/100+SAL)/100+((60*SAL)/100+SAL)),2) AS 'SUELDO_2023' 
FROM empleados
ORDER BY ENAME;
-- 47) Lista los nombres y fecha de contratacion de aquellos empleados que no son vendedores (SALESMAN).
SELECT ENAME, HIREDATE FROM empleados WHERE JOB NOT LIKE 'SALESMAN';
-- 48) Obten la informacion disponible de los empleados cuyo numero es uno de los 
-- siguientes: 7844, 7900, 7521, 7521, 7782, 7934, 7678 y 7369, pero que no sea uno 
-- de los siguientes: 7902, 7839, 7499 ni 7878. La sentencia no debe complicarse 
-- innecesariamente, y debe dar el resultado correcto independientemente de lo 
-- empleados almacenados en la base de datos.
SELECT * FROM EMPLEADOS 
WHERE 
	EMPNO = 7844  
    OR EMPNO = 7900 
    OR EMPNO = 7521 
    OR EMPNO = 7782 
    OR EMPNO= 7934 
    OR EMPNO= 7678 
    OR EMPNO = 7369;

-- 49) Ordena los empleados por su codigo de departamento, y luego de manera descendente por su numero de empleado.
SELECT * FROM EMPLEADOS ORDER BY DEPTNO , EMPNO DESC;
-- 50) Para los empleados que tengan como jefe a un empleado con codigo mayor que 
-- el suyo, obten los que reciben de salario mas de 1000 y menos de 2000, o que estan en el departamento 30.
SELECT ENAME FROM EMPLEADOS WHERE MGR > EMPNO AND (SAL BETWEEN 1000 AND 2000 OR DEPTNO=30);
-- 51) Obten el salario mas alto de la empresa, el total destinado a 
-- comisiones y el numero de empleados.
SELECT MAX(SAL), SUM(COMM), COUNT(ENAME) AS 'NÚMERO DE EMPLEADOS' FROM EMPLEADOS;
-- 52) Halla los datos de los empleados cuyo salario es mayor que el del empleado de codigo 7934, ordenando por el salario.
SELECT * FROM EMPLEADOS WHERE SAL > (SELECT SAL FROM EMPLEADOS WHERE EMPNO = 7934) ORDER BY SAL;
-- 53) Obten informacion en la que se reflejen los nombres, empleos y salarios tanto de 
-- los empleados que superan en salario a Allen como del propio Allen.
SELECT ENAME, JOB, SAL FROM EMPLEADOS WHERE SAL >= (SELECT SAL FROM EMPLEADOS WHERE ENAME LIKE 'ALLEN');
-- 54) Halla el nombre el ultimo empleado por orden alfabetico.
SELECT MAX(ENAME) FROM EMPLEADOS ORDER BY ENAME;
-- 55) Halla el salario mas alto, el mas bajo, y la diferencia entre ellos.
SELECT MAX(SAL), MIN(SAL), MAX(SAL)-MIN(SAL) AS 'DIFERENCIA' FROM EMPLEADOS;
-- 56)Sin conocer los resultados del ejercicio anterior, Â¿quienes reciben el 
-- salario mas alto y el mas bajo, y a cuanto ascienden estos salarios?
SELECT ENAME, SAL FROM EMPLEADOS WHERE SAL=(SELECT MAX(SAL) FROM EMPLEADOS) OR SAL=(SELECT MIN(SAL) FROM EMPLEADOS) ORDER BY SAL DESC;
-- 57) Considerando empleados con salario menor de 5000, halla la media de los salarios 
-- de los departamentos cuyo salario minimo supera a 900. Muestra tambien el codigo y 
-- el nombre de los departamentos.
SELECT
    e.DEPTNO,
    d.DNAME,
    AVG(e.SAL)
FROM
    empleados e
JOIN
    departamentos d
ON
    e.DEPTNO = d.DEPTNO
WHERE
    e.SAL < 5000
GROUP BY
    e.DEPTNO
HAVING
    MIN(e.SAL) > 900;
-- 58) Â¿Que empleados trabajan en ciudades de mas de cinco letras? Ordena el resultado 
-- inversamente por ciudades y normalmente por los nombres de los empleados.
SELECT ENAME FROM EMPLEADOS JOIN DEPARTAMENTOS USING (DEPTNO) WHERE LENGTH(LOC) >=5 ORDER BY LOC DESC, ENAME;
-- 59) Halla los empleados cuyo salario supera o coincide con la media del salario de la empresa.
SELECT ENAME FROM EMPLEADOS WHERE SAL >= (SELECT AVG(SAL) FROM EMPLEADOS);
-- 60) Obten los empleados cuyo salario supera al de sus compa~neros de departamento.
SELECT ENAME, SAL FROM EMPLEADOS E INNER JOIN DEPARTAMENTOS D ON E.DEPTNO = D.DEPTNO WHERE SAL IN (SELECT MAX(SAL) FROM EMPLEADOS WHERE deptno = E.DEPTNO);
-- 61) Â¿Cuantos empleos diferentes, cuantos empleados, y cuantos salarios diferentes 
-- encontramos en el departamento 30, y a cuanto asciende la suma de salarios de dicho departamento?
SELECT COUNT(DISTINCT JOB), COUNT(ENAME), COUNT(DISTINCT SAL), SUM(SAL) FROM EMPLEADOS WHERE DEPTNO =30;
-- 62) Â¿Cuantos empleados tienen comision?
SELECT COUNT(COMM) FROM EMPLEADOS WHERE COMM IS NOT NULL;
-- 63) Â¿Cuantos empleados tiene el departamento 20?
SELECT COUNT(*) FROM EMPLEADOS WHERE DEPTNO = 20;
-- 64) Halla los departamentos que tienen mas de tres empleados, y el numero de empleados de los mismos.
SELECT DEPTNO, COUNT(ENAME) FROM EMPLEADOS GROUP BY DEPTNO HAVING COUNT(*) > 3 ;
-- *65) Obten los empleados del departamento 10 que tienen el mismo empleo que 
-- alguien del departamento de Ventas. Desconocemos el codigo de dicho departamento.
SELECT E.ENAME FROM EMPLEADOS E JOIN DEPARTAMENTOS D USING(DEPTNO) WHERE DEPTNO=10 AND JOB IN (SELECT E.JOB FROM EMPLEADOS E JOIN DEPARTAMENTOS D WHERE DNAME LIKE 'SALES');
-- *66) Halla los empleados que tienen por lo menos un empleado a su mando, ordenados inversamente por nombre.
SELECT E.ENAME FROM EMPLEADOS E JOIN EMPLEADOS F ON E.MGR=F.EMPNO GROUP BY E.MGR HAVING COUNT( E.ENAME) > 0  ORDER BY E.ENAME DESC; 
-- * 67) Obten informacion sobre los empleados que tienen el mismo trabajo que 
-- algun empleado que trabaje en Chicago.
SELECT * FROM EMPLEADOS E  JOIN DEPARTAMENTOS D ON E.DEPTNO=D.DEPTNO WHERE E.JOB IN (SELECT JOB FROM EMPLEADOS  WHERE LOC LIKE 'CHICAGO');
SELECT JOB FROM EMPLEADOS JOIN DEPARTAMENTOS WHERE LOC LIKE 'CHICAGO';
-- 68) Â¿Que empleos distintos encontramos en la empresa, y cuantos empleados desempeÃ±an cada uno de ellos?
SELECT JOB, COUNT(DISTINCT JOB), COUNT(ENAME) FROM EMPLEADOS GROUP BY JOB;
-- 69) Halla la suma de salarios de cada departamento.
SELECT DEPTNO, SUM(SAL) FROM EMPLEADOS GROUP BY DEPTNO;
-- 70) Obten todos los departamentos sin empleados.
SELECT DNAME FROM DEPARTAMENTOS D LEFT JOIN EMPLEADOS E USING(DEPTNO) WHERE EMPNO IS  NULL;
-- 71) Halla los empleados que no tienen a otro empleado a sus ordenes.
SELECT ENAME FROM EMPLEADOS e  WHERE NOT EXISTS (SELECT ENAME FROM EMPLEADOS e2 WHERE e2.mgr=e.empno);
-- 72) Â¿Cuantos empleados hay en cada departamento, y cual es la media anual 
-- del salario de cada uno (el salario almacenado es mensual)? 
-- Indique el nombre del departamento para clarificar el resultado.
SELECT DNAME, COUNT(*), AVG(SAL) FROM DEPARTAMENTOS JOIN EMPLEADOS USING(DEPTNO)GROUP BY DNAME;
-- 73) Halla los empleados del departamento 30, por orden descendente de comision
SELECT ENAME FROM EMPLEADOS WHERE DEPTNO =30 ORDER BY COMM DESC;
-- 74) Obten los empleados que trabajan en Dallas o New York.
SELECT ENAME FROM EMPLEADOS E  JOIN DEPARTAMENTOS D USING(DEPTNO) WHERE LOC LIKE 'DALLAS' OR LOC LIKE 'NEW YORK' ORDER BY ENAME;
-- 75) Obten un listado en el que se reflejen los empleados y los nombres 
-- de sus jefes. En el listado deben aparecer todos los empleados, aunque no 
-- tengan jefe, poniendo un nulo el nombre de este.
SELECT E.ENAME, M.ENAME AS 'MANAGER'
FROM   EMPLEADOS E
JOIN   EMPLEADOS M on E.MGR=M.EMPNO;
-- *76) Lista los empleados que tengan el mayor salario de su departamento, 
-- mostrando el nombre del empleado, su salario y el nombre del departamento.
select ENAME, d.DNAME, e.sal
    from EMPLEADOS  e join DEPARTAMENTOS D
    on e.DEPTNO=d.DEPTNO
    group by  d.DNAME having max(sal);

-- 77) Deseamos saber cuantos empleados supervisa cada jefe. Para ello, obten un listado 
-- en el que se reflejen el codigo y el nombre de cada jefe, junto al numero de empleados 
-- que supervisa directamente. Como puede haber empleados sin jefe, para estos se indicara 
-- solo el numero de ellos, y los valores restantes (codigo y nombre del jefe) se dejaran como nulos.
SELECT   E.MGR AS 'MANAGER_COD', f.ename AS 'NOMBRE MANAGER', COUNT(e.ENAME) FROM EMPLEADOS E LEFT JOIN EMPLEADOS F ON E.MGR=F.EMPNO group by F.ename;
-- 78) Hallar el departamento cuya suma de salarios sea la mas alta, mostrando esta 
-- suma de salarios y el nombre del departamento
SELECT D.DNAME, SUM(SAL) AS 'SUMA DE SALARIOS' FROM DEPARTAMENTOS D JOIN EMPLEADOS E ON D.DEPTNO=E.DEPTNO GROUP BY DNAME ORDER BY SAL LIMIT 1;
-- 79) Obten los datos de los empleados que cobren los dos mayores salarios de la empresa. 
-- (Nota: Procure hacer la consulta de forma que sea facil obtener los empleados de los N mayores salarios)
SELECT * FROM (SELECT * FROM empleados ORDER BY sal DESC LIMIT 2) AS Emp ORDER BY sal LIMIT 2;
-- 80) Obten las localidades que no tienen departamentos sin empleados y en las que 
-- trabajen al menos cuatro empleados. Indica tambien el numero de empleados que trabajan 
-- en esas localidades. -- (Nota: Por ejemplo, puede que en A Coru~na existan dos departamentos, 
-- uno con mas de cuatro empleados y otro sin empleados, en tal caso, A Coru~na no debe 
-- aparecer en el resultado, puesto que tiene un departamento SIN EMPLEADOS, a pesar de tener 
-- otro con empleados Y tener mas de cuatro empleados EN TOTAL. 
-- ATENCION, la restriccion de que tienen que ser cuatro empleados se refiere a la totalidad 
-- de los departamentos de la localidad.-- )
SELECT LOC FROM (SELECT D.DNAME FROM DEPARTAMENTOS D JOIN EMPLEADOS E USING(EMPNO)  WHERE E.EMPNO IS NOT NULL) AS QUERY1 
WHERE DNAME IN (
SELECT DNAME, COUNT(ENAME) FROM EMPLEADOS GROUP BY DNAME HAVING COUNT(*) > 3 );   


