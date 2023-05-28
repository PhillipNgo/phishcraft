# Build and test

1. Run `.\gradlew.bat build`
2. This will generate a file `/build/libs/phishcraft-X.X.jar`
3. In CurseForge, open the file location of your test server
4. Copy the jar file into the mods folder of the test server
5. Launch the test server 

# First time setup

1. Install the Java JDK
    - https://www.oracle.com/java/technologies/downloads/#jdk17-windows
2. Clone the repository
    - Doing this in a VS Code terminal will automate some permissioning
    - `git clone https://github.com/PhillipNgo/phishcraft.git`
3. Run setup
    - In windows command line
    - `.\gradlew.bat genVSCodeRuns`
    - `.\gradlew.bat --refresh-dependencies`
4. Install the following VS Code extensions
    - Gradle for Java
    - Language Support for Java(TM) by Red Hat
    - Debugger for Java
    - Close and open VS Code after installing
5. Create a test server
    - Open CurseForge
    - Click `Create Custom Profile`
    - Minecraft Version: Anything higher than 1.19.0
    - Game Type: Forge
    - Modloader Version: Default
6. Sanity Check
    - Running `.\gradlew.bat build` should succeed
    - There should be no errors in VS code