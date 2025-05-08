---

# 6 Nimmt!

A Java implementation of the classic card game **6 Nimmt!** (Take 6). This repository contains the logic and rules of the game, allowing players to experience the fun and challenge of this strategic card game.

## Table of Contents

- [About the Game](#about-the-game)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Usage](#usage)
- [Rules of the Game](#rules-of-the-game)
- [Contributing](#contributing)
- [License](#license)

---

## About the Game

**6 Nimmt!** is a card game known for its simple rules and strategic depth. Players aim to avoid collecting penalty cards while trying to outsmart opponents. This project brings the game to life using Java, providing an opportunity to play or explore its implementation.

## Features

- Full implementation of **6 Nimmt!** rules.
- Support for multiple players.
- Randomized card distribution for each game session.
- Customizable settings (optional).

## Getting Started

### Prerequisites

To run or build this project, ensure you have the following installed:

- Java Development Kit (JDK) version 8 or higher
- An IDE or text editor for Java (e.g., IntelliJ IDEA, Eclipse, or VS Code)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/goodtam8/6nimmt.git
   ```

2. Navigate to the project directory:
   ```bash
   cd 6nimmt
   ```

### Usage

1. Compile the project:
   ```bash
   javac -d bin src/*.java
   ```

2. Run the game:
   ```bash
   java -cp bin Main
   ```

## Rules of the Game

1. **Objective**: Avoid collecting penalty cards.
2. **Setup**:
   - Each player is dealt 10 cards.
   - Four rows are initialized with one card each.
3. **Gameplay**:
   - Each round, players choose a card to play.
   - Cards are placed in ascending order in rows.
   - If a card cannot fit in a row, the player takes the row and its penalty points.
4. **Game End**:
   - The game ends after 10 rounds.
   - The player with the fewest penalty points wins.

For more detailed rules, refer to the official rulebook of **6 Nimmt!**.

## Contributing

Contributions are welcome! If you'd like to improve the project or fix issues, follow these steps:

1. Fork the repository.
2. Create a new branch for your changes:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add feature-name"
   ```
4. Push to your branch:
   ```bash
   git push origin feature-name
   ```
5. Open a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

---

