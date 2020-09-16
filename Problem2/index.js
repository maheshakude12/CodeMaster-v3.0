var Inp = prompt('Enter You Input Data');
var res = Inp.split(" ");
for(var i=1; i<res.length; i++){
    var num = res[i];
    while(num > 0){
        var splitNum = num.toString().split("");
        console.log(splitNum);
            var f = 1;
            for(var j=0; j<splitNum.length-1; j++){
                if(splitNum[j+1] < splitNum[j]){
                    f = 0;
                    break;
                }
            }
            if(f == 1){
                console.log('Request-'+ i + ':' + num);
                break;
            }
            num = num - 1;
    }
}