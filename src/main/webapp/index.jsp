<!DOCTYPE html>
<html ng-app="app">
<head>
<!-- LIBS CSS -->
 <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.css">
<!-- LIBS JS -->
 <script src="webjars/angularjs/1.4.7/angular.js"></script>
<script src="webjars/angularjs/1.4.7/angular-resource.js"></script>
<script src="webjars/angular-smart-table/2.1.4/dist/smart-table.js"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
 <script src="webjars/ng-table/0.3.3/ng-table.min.js" type="text/javascript"></script>
  
    <script src="webjars/angular-filter/0.4.9/angular-filter.js" type="text/javascript"></script>
<!-- YOUR JS -->
<script src="app.js"></script>
</head>
<body ng-controller="TableCtrl">
<div class="container">


<form ng-controller="TableCtrl">
<h3>Please enter Phone number</h3>
<!-- pattern="^d{10}$" max="10" -->
      Phone Number: <input name="phnNo" type="text" ng-model="phoneNo" ng-value="{{phoneNo}}"class="form-inline" ng-pattern="/^[0-9]*$/" title="Please enter phone number" 
                          			 placeholder="1234567890"/>  
 <input id="" type="submit" class="btn" ng-click="validateNumber()" />
 <div>
 <span>
 Count Of Combination is {{count}}</span>
<table class="table" ng-table="tableParams" >
<th>Output</th>
<tr ng-repeat="invoiceTerm in $data " style="text-align:left;">
 <td >{{invoiceTerm}}</td>
</tr>
</table>
</div>
</form>    
</div>
</body>
</html>