import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {

	char selectedAction = ' ';
	double currentResult = 0;
	Calculator parent;

	public CalculatorEngine(Calculator parent) {

		this.parent = parent;

	}

	public void actionPerformed(ActionEvent e) {

		double displayValue = 0;
		// Получаем источник события
		JButton clickedButton = (JButton) e.getSource();
		// Получаем надпись на кнопке
		// String clickedButtonLabel = clickedButton.getText();
		String dispFieldText = parent.displayField.getText();

		if (!"".equals(dispFieldText)) {
			try {
				displayValue = Double.parseDouble(dispFieldText);
			} catch (NumberFormatException e2) {
				javax.swing.JOptionPane.showConfirmDialog(null,
						"Пожалуйста, введите число", "Неправильный ввод",
						javax.swing.JOptionPane.PLAIN_MESSAGE);
						return;
			}

		}

		Object src = e.getSource();
		// Для каждой кнопки арифметического действия
		// запомнить его: +, -, /, или *, сохранить текущее число
		// в переменной currentResult, и очистить дисплей
		// для ввода нового числа
		if (src == parent.buttonPlus) {
			selectedAction = '+';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonMinus) {
			selectedAction = '-';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonDivided) {
			selectedAction = '/';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonMultiplied) {
			selectedAction = '*';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonPoint) {

			if (dispFieldText.indexOf(".") == -1) {
				parent.displayField.setText(dispFieldText + ".");
			}

		} else if (src == parent.buttonEqual) {
			// Совершить арифметическое действие, в зависимости
			// от selectedAction, обновить переменную currentResult
			// и показать результат на дисплее
			if (selectedAction == '+') {
				currentResult += displayValue;
				// Сконвертировать результат в строку, добавляя его
				// к пустой строке и показать его
				parent.displayField.setText("" + currentResult);
			} else if (selectedAction == '-') {
				currentResult -= displayValue;
				parent.displayField.setText("" + currentResult);
			} else if (selectedAction == '/') {
				if (displayValue == 0)
					currentResult = 0;
				else
					currentResult /= displayValue;
				parent.displayField.setText("" + currentResult);
			} else if (selectedAction == '*') {
				currentResult *= displayValue;
				parent.displayField.setText("" + currentResult);
			}
		} else {
			// Для всех цифровых кнопок присоединить надпись на
			// кнопке к надписи в дисплее
			String clickedButtonLabel = clickedButton.getText();
			parent.displayField.setText(dispFieldText + clickedButtonLabel);
		}
	}

}
