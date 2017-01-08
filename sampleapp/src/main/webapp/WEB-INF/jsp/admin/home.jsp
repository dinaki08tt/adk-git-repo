<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Admin Page</title>
</head>
<body>
<!-- ========= -->
  <!-- Your HTML -->
  <!-- ========= -->

  <div id="container">Loading...</div>

  <!-- ========= -->
  <!-- Libraries -->
  <!-- ========= -->
  <script src="https://code.jquery.com/jquery-2.1.3.min.js" type="text/javascript"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.3.3/underscore-min.js" type="text/javascript"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/backbone.js/0.9.2/backbone-min.js" type="text/javascript"></script>


  <!-- =============== -->
  <!-- Javascript code -->
  <!-- =============== -->
  <script type="text/javascript">
    var AppView = Backbone.View.extend({
      // el - stands for element. Every view has an element associated with HTML content, will be rendered.
      el: '#container',
      // It's the first function called when this view is instantiated.
      initialize: function(){
        this.render();
      },
      // $el - it's a cached jQuery object (el), in which you can use jQuery functions to push content. Like the Hello TutorialsPoint in this case.
      render: function(){
        this.$el.html("Hello TutorialsPoint!!!");
      }
    });

    var appView = new AppView();
  </script>

</body>
</html>