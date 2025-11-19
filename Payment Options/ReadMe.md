# Payment Factory Pattern

A Java implementation demonstrating the Factory Design Pattern for payment processing systems.

## Project Structure

- **Payment** (Interface)
  - `pay(double amount)` method

- **CardPayment** (Class)
  - Implements `Payment` interface
  - Handles card payment transactions

- **PayPalPayment** (Class)
  - Implements `Payment` interface
  - Handles PayPal payment transactions

- **PaymentFactory** (Class)
  - `createPayment(String type)` method
  - Returns appropriate payment instances based on type

## Usage

```java
// Create card payment
Payment cardPayment = PaymentFactory.createPayment("card");
cardPayment.pay(100.0);

// Create PayPal payment
Payment paypalPayment = PaymentFactory.createPayment("paypal");
paypalPayment.pay(50.0);
