
# MVVM Retrofit

**1, What is the MVVM**\
MVVM is a software design pattern used by programmers to develop user interfaces for web applications. It makes it easy to maintain and develop complicated user interfaces. The viewmodel in MVVM is efficient in managing data and business logic

2, What is the MVVM Android]
MVVM stands for Model, View, ViewModel. Model: This holds the data of the application. It cannot directly talk to the View. Generally, it's recommended to expose the data to the ViewModel through Observables. View: It represents the UI of the application devoid of any Application Logic.

3, What is the ViewModelObserver

Attach the Observer object to the LiveData object using the observe() method. The observe() method takes a LifecycleOwner object. This subscribes the Observer object to the LiveData object so that it is notified of changes. You usually attach the Observer object in a UI controller, such as an activity or fragment.

<!-- ![Alt text](https://github.com/prasanth9689/MVVM_Retrofit_API_Activity/blob/master/screenshots/Screenshot_20230111_193527.png?raw=true "Optional title") -->
<a href="url"><img src="https://github.com/prasanth9689/MVVM_Retrofit_API_Activity/blob/master/screenshots/Screenshot_20230111_193527.png?raw=true" align="left" height="600" width="300" ></a>