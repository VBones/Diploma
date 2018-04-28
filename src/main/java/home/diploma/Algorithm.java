/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.diploma;

/**
 *
 * @author Влад
 */
public class Algorithm {
/**    
 * Ввод матрицы расстояний D
 * inputMatrix();
 * 
 Инициализация параметров алгоритма α (alpha),
β (beta), e, Q, τ0 (tau0)
* public static final int ALPHA;
* public static final int BETA;
* public static final int E;
* public static final int Q;
* public static final int TAU0;
* 
m=n % Количество муравьев равно числу городов
For i=1:n
For j=1:n % Для каждого ребра
If i~=j
eta(i,j)=1/D(i,j); % Видимость
tau(i,j)= tau0; % Феромон
Else tau(i,j)=0;
% Переход из одного города в тот же самый
% невозможен
End
End
End
For k=1:m
<Разместить муравья k в случайно выбранный
город>
End
<Выбрать условно#кратчайший маршрут Т+ и
рассчитать его длину L+>
% Основной цикл
For t=1:tmax
% tmax # количество итераций алгоритма
For k=1:m % Для каждого муравья
<Построить маршрут Тk(t) по правилу (1) и
рассчитать длину Lk(t)>
End
If < “Лучшее решение найдено?” >
<Обновить Т+ и L+ >
End
For i=1:n
For j=1:n % Для каждого ребра
<Обновить следы феромона по правилам (2) и
(3).>
End
End
End
<Вывести кратчайший маршрут Т+ и его длину L+>
*/
}
