import java.util.logging.Logger;
public class ComplexCalculator {
    private Logger logger;


    public ComplexCalculator(Logger logger) {
        this.logger = logger;
    }

    public Complex add(Complex a, Complex b) {
        double real = a.getReal() + b.getReal();
        double imag = a.getImaginary() + b.getImaginary();
        Complex result = new Complex(real, imag);
        logger.info(&quot;Addition: &quot; + a + &quot; + &quot; + b + &quot; = &quot; + result);
        return result;
    }

    public Complex multiply(Complex a, Complex b) {
        double real = a.getReal() * b.getReal() - a.getImaginary() * b.getImaginary();
        double imag = a.getReal() * b.getImaginary() + a.getImaginary() * b.getReal();
        Complex result = new Complex(real, imag);
        logger.info(&quot;Multiplication: &quot; + a + &quot; * &quot; + b + &quot; = &quot; + result);
        return result;
    }

    public Complex divide(Complex a, Complex b) {
        double denominator = b.getReal() * b.getReal() + b.getImaginary() * b.getImaginary();
        double real = (a.getReal() * b.getReal() + a.getImaginary() * b.getImaginary()) / denominator;
        double imag = (a.getImaginary() * b.getReal() - a.getReal() * b.getImaginary()) / denominator;
        Complex result = new Complex(real, imag);
        logger.info(&quot;Division: &quot; + a + &quot; / &quot; + b + &quot; = &quot; + result);
        return result;
    }

}

public class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    @Override
    public String toString() {
        if (imaginary < 0) {
            return real + " - " + Math.abs(imaginary) + "i";
        } else {
            return real + " + " + imaginary + "i";
        }
    }
}
    Использование логирования в калькуляторе комплексных чисел:

        import java.util.logging.ConsoleHandler;
        import java.util.logging.Level;
        import java.util.logging.Logger;
        import java.util.logging.SimpleFormatter;
public class Main {
    public static void main(String[] args) {
// Создание логгера
        Logger logger = Logger.getLogger(Main.class.getName());
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(consoleHandler);


        // Создание калькулятора
        ComplexCalculator calculator = new ComplexCalculator(logger);

        // Выполнение операций
        Complex a = new Complex(2, 3);
        Complex b = new Complex(4, -5);

        Complex sum = calculator.add(a, b);
        Complex product = calculator.multiply(a, b);
        Complex quotient = calculator.divide(a, b);
    }

}
