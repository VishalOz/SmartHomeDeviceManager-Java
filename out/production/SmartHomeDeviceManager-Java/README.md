# SmartHomeDeviceManager-Java

# 🏠 Smart Home Device Management System (Java)

This is a Java-based **Smart Home Device Management System** that uses **Object-Oriented Programming (OOP)** principles to simulate managing smart devices like lights and ACs. It runs on the console and provides features like device control, scheduling, energy monitoring, and room grouping.

---

## 📚 Features

- ✅ Add smart devices (Light, AC)
- 🔁 Turn devices ON/OFF
- 📅 Schedule device operations
- ⚡ Monitor energy usage
- 🏘️ Group devices into rooms
- 🧠 Menu-driven console interface

---

## 🧠 OOP Concepts Used

| Concept            | Usage                                      |
|--------------------|---------------------------------------------|
| **Encapsulation**  | Devices keep internal state private         |
| **Inheritance**    | Common `SmartDevice` class extended         |
| **Abstraction**    | Abstract methods for status display         |
| **Polymorphism**   | Interactions via base class/interface       |
| **Interface**      | `Schedulable`, `EnergyMonitorable`          |
| **Composition**    | `Room` holds a list of devices              |

---

## 💻 How to Run

### 1. Clone the repository
```bash
git clone https://github.com/YOUR_USERNAME/SmartHomeDeviceManager-Java.git
cd SmartHomeDeviceManager-Java
