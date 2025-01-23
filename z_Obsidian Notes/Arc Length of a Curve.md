The **arc length of a curve** is commonly used in **spatial data analysis** to measure distances along curved paths like roads or flight routes, critical for GPS tracking and route optimization. In **time-series analysis**, it quantifies variability in trends, such as stock prices or temperature changes. In **machine learning**, it serves as a feature for shape and gesture analysis, aiding tasks like handwriting recognition and object detection.

The length of a smooth curve $y=f(x)$from $x=a$ to $x=b$ is: 
$L = \int_a^b \sqrt{1 + \left( f'(x) \right)^2} , dx$

For parametric equations $x=x(t)$, $y=y(t)$: $L = \int_{t_1}^{t_2} \sqrt{\left( \frac{dx}{dt} \right)^2 + \left( \frac{dy}{dt} \right)^2} , dt$

Tags:
[[Integral]]