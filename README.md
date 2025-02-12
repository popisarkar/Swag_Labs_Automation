 # 🚀 Swag Labs Automation  

## 📌 Selenium WebDriver with Java - Comprehensive Guide  

### 📝 Overview  
This repository provides a **step-by-step guide** to using **Selenium WebDriver** with **Java** for **automated testing**. Whether you're a beginner or an experienced tester, this guide covers everything from **setup** to **advanced browser handling** techniques.  

---

## 📂 Getting Started  
Follow the steps below to set up your development environment and start working with **Selenium WebDriver** in Java.  

---

## ✅ Prerequisites  
Before starting, ensure you have the following installed:  

### 1️⃣ Java Development Kit (JDK)  
- [Download Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html)  
- Install and set up **environment variables** (explained below).  

### 2️⃣ Integrated Development Environment (IDE)  
Choose one of the following IDEs:  
- [Eclipse](https://www.eclipse.org/)  
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)  
- [Spring Tools](https://spring.io/tools)  

### 3️⃣ Apache Maven  
- [Download Apache Maven](https://maven.apache.org/download.cgi)  
- Follow the installation instructions.  

---

## 🛠 Installation Guide  

### **Step 1: Install Java JDK**  
1. Download the **JDK installer** from [Oracle Java SE Downloads](https://www.oracle.com/java/technologies/javase-downloads.html).  
2. Run the installer and **follow the setup instructions**.  
3. Set up **environment variables**:  
   - Open **System Properties** → Go to **Advanced System Settings**.  
   - Click on **Environment Variables**.  
   - Under **System Variables**, click **New** and enter:  
     - **Variable name:** `JAVA_HOME`  
     - **Variable value:** Path to your JDK installation (e.g., `C:\Program Files\Java\jdk-XX.X.X`).  
   - Find the `Path` variable, **edit** it, and add `%JAVA_HOME%\bin`.  
4. **Verify Java installation** by running the following command in the terminal:  
   ```sh
   java --version
## 🚀 Step 2: Install an IDE  

1. Choose an IDE from the list above (**Eclipse, IntelliJ IDEA, or Spring Tools**).  
2. Download and **install** your preferred IDE.  
3. Configure **Maven integration** if required.  

---

## 🛠 Step 3: Install Apache Maven  

1. **Download Apache Maven** from the [official website](https://maven.apache.org/download.cgi).  
2. Extract the **ZIP file** to a location on your computer (e.g., `C:\Maven`).  
3. **Set up environment variables:**  
   - Add a **new System Variable**:  
     - **Variable name:** `MAVEN_HOME`  
     - **Variable value:** Path to your Maven folder (e.g., `C:\Maven`).  
   - Edit the `Path` variable and **add** `%MAVEN_HOME%\bin`.  
4. **Verify Maven installation** by running the following command in the terminal:  
   ```sh
   mvn -version
                                         

# 🚀 Page Object Model (POM) - Selenium Framework  

## 📌 Overview  
This project follows the **Page Object Model (POM)** to organize Selenium automation scripts efficiently.  
POM improves **code reusability, readability, and maintainability** by keeping test logic separate from UI interactions.  

---

## 📂 Project Structure  
The project is organized into **separate folders** to maintain clarity and scalability.  

### 📁 **1. Page Classes (`pages/`)**  
- This folder contains **Page Object Classes**, each representing a specific web page.  
- Each class includes **locators** and **methods** to interact with web elements.  

#### 📄 **Page Classes:**
- 🏷 [**BasePage**](https://www.oracle.com/java/technologies/javase-downloads.html)
- 💳[ **CheckOutPage**](https://github.com/popisarkar/Swag_Labs_Automation/blob/main/Interview_QS_solve/src/test/java/pages/CheckOutPage.java)
- 🔒 [**LockOutUserPage**](https://github.com/popisarkar/Swag_Labs_Automation/blob/main/Interview_QS_solve/src/test/java/pages/LockOutUserPage.java)
- 🔑 [**LoginPage**](https://github.com/popisarkar/Swag_Labs_Automation/blob/main/Interview_QS_solve/src/test/java/pages/LogInPage.java)
- 🚪[ **LogOutPage**](https://github.com/popisarkar/Swag_Labs_Automation/blob/main/Interview_QS_solve/src/test/java/pages/LogOutPage.java)
- 📦[ **ProductPage**](https://github.com/popisarkar/Swag_Labs_Automation/blob/main/Interview_QS_solve/src/test/java/pages/ProductPage.java)
- 📊 [**SortingProductsPage**](https://github.com/popisarkar/Swag_Labs_Automation/blob/main/Interview_QS_solve/src/test/java/pages/SortingProductsPage.java)  

---

### 📁 **2. Test Scripts (`testcases/`)**  
- This folder contains **Test Cases**, which use page classes to execute test scenarios.  
- Each test script should be named after the feature it tests.  

#### 📄 **Test Case Files:**
- ✅ [**TestCartBadgeCount**](https://github.com/popisarkar/Swag_Labs_Automation/blob/main/Interview_QS_solve/src/test/java/testcases/TestCartBadgeCount.java)
- ✅ [**TestCheckOutPage**](https://github.com/popisarkar/Swag_Labs_Automation/blob/main/Interview_QS_solve/src/test/java/testcases/TestCheckOutPage.java)
- ✅ [**TestLockOutUser**](https://github.com/popisarkar/Swag_Labs_Automation/blob/main/Interview_QS_solve/src/test/java/testcases/TestLockOutUser.java)
- ✅ [**TestLogin**](https://github.com/popisarkar/Swag_Labs_Automation/blob/main/Interview_QS_solve/src/test/java/testcases/TestLogIn.java)
- ✅[**TestLogOut**](https://github.com/popisarkar/Swag_Labs_Automation/blob/main/Interview_QS_solve/src/test/java/testcases/TestLogOut.java)
- ✅ [**TestProductPage**](https://github.com/popisarkar/Swag_Labs_Automation/blob/main/Interview_QS_solve/src/test/java/testcases/TestProductPage.java)
- ✅ [**TestSortingProductsPage** ](https://github.com/popisarkar/Swag_Labs_Automation/blob/main/Interview_QS_solve/src/test/java/testcases/TestSortingProductsPage.java) 

---

### 📁 **3. Utilities (`utilities/`)**  
- This folder contains **helper classes**, such as:  

#### 🛠 **Utility Files:**
- ⚙️[ **DriverSetUp**]() → Manages WebDriver initialization.  

---

## ✅ Best Practices  
✔️ **Follow Naming Conventions** → Class names should be **clear and descriptive**.  
✔️ **Avoid Hardcoding Values** → Use configuration files for URLs, credentials, etc.  
✔️ **Write Reusable Methods** → Keep test scripts clean by using methods from page classes.  
✔️ **Keep Test Logic Separate** → Test scripts should **only call page methods**, not directly interact with locators.  

---

## 🚀 Benefits of Using POM  
✅ **Enhances Code Reusability**  
✅ **Reduces Maintenance Effort**  
✅ **Improves Readability & Structure**  
✅ **Makes Debugging Easier**  

By following this structured approach, your automation framework will be **modular, reusable, and easy to maintain**. 🎯  
