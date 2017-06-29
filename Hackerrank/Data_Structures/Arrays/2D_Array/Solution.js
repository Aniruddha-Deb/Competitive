process.stdin.resume();
process.stdin.setEncoding('ascii');

var input_stdin = "";
var input_stdin_array = "";
var input_currentline = 0;

process.stdin.on('data', function (data) {
    input_stdin += data;
});

process.stdin.on('end', function () {
    input_stdin_array = input_stdin.split("\n");
    main();    
});

function readLine() {
    return input_stdin_array[input_currentline++];
}

/////////////// ignore above this line ////////////////////

function main() {
    var arr = [];
    for(arr_i = 0; arr_i < 6; arr_i++){
       arr[arr_i] = readLine().split(' ');
       arr[arr_i] = arr[arr_i].map(Number);
    }
    
    highestSum = -500;
    for( i=0; i<6; i++ ) {
        for( j=0; j<arr.length; j++ ) {
            if( j >= 1 && j <= 4 && i >= 1 && i <= 4 ) {
                sum = arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] + 
                                      arr[i][j]                   +
                      arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1] ;
                if( sum > highestSum ) {
                    highestSum = sum;
                }
            }
        }
    }
    
    console.log( highestSum );
}
