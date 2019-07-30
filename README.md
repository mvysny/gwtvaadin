# GWT + Maven + Vaadin 14

This project demoes the possibility of having both old
GWT codebase running along with the new Vaadin 14 servlet
in the same session.

You need to have the following installed:

* Java JDK, 8 or newer
* Intellij Ultimate
* Tomcat 9.x; for example download Tomcat 9.0.22 from https://tomcat.apache.org/download-90.cgi

## Run the dev env
 
In order to run this project you need to run the following in your terminal: 

1. `mvn clean package`
2. `mvn gwt:codeserver`

That would start the GWT in SuperDevMode. This process will
automatically recompile your GWT java sources to javascript and serve them to
the webpage.

> Note: Do **not** use `mvn gwt:devmode` which will start the old GWT DevMode.
Development using old GWT DevMode requires a browser plugin which doesn't work with
any of recent browsers. GWT DevMode will also start Vaadin app with very old Jetty
which doesn't handle Java 9 bytecode properly and will crash that it can't parse `versions/9/module-info.class` from `byte-buddy.jar`

Now you need to run the server itself. Download Tomcat as stated above, and
create a Tomcat launch configuration in your Intellij Ultimate:
Edit Configurations / + / Tomcat Server / Local. Make sure that:

* In the launch configuration's Deployment tab the following is deployed:
`GwtTest:war exploded`
* The Application Context is `/`

> Tip: There is [Youtube video which will guide you through the process of
installing Tomcat](https://www.youtube.com/watch?v=M0Q7D03bYXc&t=10s).

Now start the newly created Tomcat launch configuration in the debug mode. Once the Tomcat starts,
Intellij should automatically open the GWT welcome page in your browser.

## Develop with GWT

Visit http://127.0.0.1:9876/ . The page will give you an opportunity
to bookmark two bookmarklets: `Dev Mode On` and `Dev Mode Off` - do it
and make sure those bookmarklets are on your bookmark toolbar in your browser.

Now visit http://localhost:8080/ and while on this page, press the `Dev Mode On` button
in your bookmark toolbar which you have bookmarked earlier. That will offer you
to recompile the GWT code on the current page in dev mode. After that's done, you can now change the
GWT sources:

1. Open the `GwtTest` class and change the button caption from `Send TO SERVER!` to e.g.
  `Say Hello!`.
2. Reload the page in your browser by pressing `F5`. The button caption should change.

## Develop with Vaadin

Visit http://localhost:8080/vaadin/categories . A list of categories should open up.
Now, open the `CategoriesList` java class and change e.g.
the `New category` button caption to e.g. `Create category`.

In order to deploy the change, simply press Ctrl+F9. That should hot-redeploy
the class into Tomcat which should now say `1 classes has been redeployed`.
Now simply reload the page in the browser - the button caption should now be changed.

> Tip: Sometimes the hot-redeployment stops working. Then simply press
Ctrl+F10 and select "Restart Server" - that should restart Tomcat with the
new code. You can also experiment with other options: "Update resources"
should update your non-java files such as CSS, HTML and others;
"Update classes and resources" should also hot-redeploy all changes.
