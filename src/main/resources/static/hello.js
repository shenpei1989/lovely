angular.module('demo',[]).controller('hello',function($scope,$http){
	$http.get('http://10.220.10.85:9195/greeting/1').then(function(response){
		$scope.user=response.data;
	},function(errorMsg){
		console.log(errorMsg);
		alert('连接失败');
		
	});
});