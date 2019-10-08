## How to configure spring-boot dev profile in IDEA

1. Create your own application-<profile_name>.yml file in resource folder.
2. Overwrite properties that you need for your profile.
3. Go to Run/Debug Configuration and create your own spring boot configuration.
4. In active profiles filed add your <profile_name> from step 1 or in VM options field add
```.env
-Dspring.profiles.active=<profile_name>
```
where <profile_name> - is your actual profile name.

5. Run this new configuration.