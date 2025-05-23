# My Application

Welcome to **My Application**, an Android project designed to demonstrate the use of modern Android development practices. This project is fully implemented in **Kotlin** and utilizes **Data Binding**, **Fragments**, and other best practices to ensure a clean and scalable codebase.

## Features
- **Bottom Navigation**: Easily navigate between multiple sections of the app.
- **Fragments**: Modularized features into `HomeFragment`, `LeaveFragment`, and `ProfileFragment`.
- **Data Binding**: Simplifies UI updates and eliminates boilerplate code.
- **Leave Submission**: Allows users to submit leave requests via a dialog interface.
- **Extensible Architecture**: Easily add new features or screens.

## Prerequisites
Before running this project, ensure that you have:
- Android Studio (latest version recommended)
- A device or emulator running Android 5.0 (Lollipop) or higher
- Kotlin 1.8 or higher configured in your environment

## Getting Started
### Clone the Repository
```bash
git clone https://github.com/Volear/my-application.git
cd my-application
```

### Open the Project
1. Launch **Android Studio**.
2. Open the project directory (`my-application`).
3. Let Android Studio sync the Gradle files.

### Build and Run
1. Connect your device or launch an emulator.
2. Click on **Run > Run 'app'** in Android Studio.
3. The app will be installed and launched on your device/emulator.

## Project Structure
```
.
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/myapplication
│   │   │   │   ├── MainActivity.kt          # Main entry point of the app
│   │   │   │   ├── fragments/               # All feature-specific fragments
│   │   │   │   ├── dialogs/                 # Dialog fragments (e.g., SubmitLeaveDialog)
│   │   │   ├── res/                         # All UI resources (layouts, drawables, etc.)
│   │   │   │   ├── layout/                  # XML layout files
│   │   │   │   ├── values/                  # Strings, colors, and styles
│   ├── build.gradle                         # Module-level Gradle config
├── README.md                                # Project documentation
```

### Key Files
- **MainActivity.kt**: Hosts the fragments and manages navigation.
- **SubmitLeaveConfirmationDialogFragment.kt**: Handles leave submission functionality.
- **LeaveFragment.kt**: Displays leave-related information.

## Contribution Guidelines
We welcome contributions! To contribute:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Submit a pull request with a clear description of your changes.

## License
This project is licensed under the [MIT License](LICENSE).

## Contact
Feel free to reach out if you have any questions: