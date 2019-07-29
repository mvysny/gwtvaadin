# GWT + Maven + Vaadin 14

This project demoes the possibility of having both old
GWT codebase running along with the new Vaadin 14 servlet
in the same session.

## Run the dev env
 
In order to run this project: 

1. mvn clean package
2. mvn gwt:codeserver

That would start the GWT in SuperDevMode. This process will
auto-recompile and serve GWT code.

> Note: Do not use `mvn gwt:devmode` which will start the old DevMode
 (which requires a browser plugin which doesn't work with the newest browsers)
and it will start Vaadin with old Jetty which doesn't handle Java 9 bytecode well
will crash that it can't parse `versions/9/module-info.class` from `byte-buddy.jar`

Now you need to run the server itself. Download Tomcat 9.0.22
and create a Tomcat launch configuration in your Intellij Ultimate:
Edit Configurations / + / Tomcat Server / Local. Make sure that:

* In the launch configuration's Deployment tab the following is deployed:
`GwtTest:war exploded`
* The Application Context is `/`

Now start Tomcat in the debug mode. It should automatically open
the GWT welcome page.

## Develop with GWT

Visit http://127.0.0.1:9876/ . The page will give you an opportunity
to bookmark two bookmarklets: `Dev Mode On` and `Dev Mode Off` - do it
and make sure those bookmarklets are on your bookmark 

Now visit http://localhost:8080/ and press the `Dev Mode On` which

1. http://localhost:8888 is gwt root
2. http://localhost:8888/vaadin is vaadin context


## Issues
If you encounter any case 
java.lang.RuntimeException: ...byte-buddy-1.9.13.jar
Please remove this jar from classpath manually and restart jety server without recompile the source.
