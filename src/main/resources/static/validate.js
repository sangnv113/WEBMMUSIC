
$(function(){
	
	$("#ername").hide();
	$("#ersoluong").hide();
	
	$("#ergia").hide();


    var vname=false;
    var vsoluong=false;
    var vgia=false;



    
    $("#name").focusout(function(){
        ckname();
    });
        function ckname(){
    	var lenght=$("#name").val().length;
    	   
    	if(lenght <=1)
    		{
    		$("#ername").html("Tên là bắt buộc!");
    		$("#ername").show();
    		 vname=true;
    		}
    	else
    		{$("#ername").hide();}
    }
        //
        $("#soluong").focusout(function(){
            cksoluong();
        });
            function cksoluong(){
        	var lenght=$("#soluong").val().length;
        	   
        	if(lenght <=0)
        		{
        		$("#ersoluong").html("Số lượng là bắt buộc!");
        		$("#ersoluong").show();
        		vsoluong=true;
        		}
        	else
        		{$("#ersoluong").hide();}
        }
            //
         
                //
                $("#gia").focusout(function(){
                    ckgia();
                });
                    function ckgia(){
                	var lenght=$("#gia").val().length;
                	   
                	if(lenght <=3)
                		{
                		$("#ergia").html("Giá không đúng!!");
                		$("#ergia").show();
                		vgia=true;
                		}
                	else
                		{$("#ergia").hide();}
                }
                   
                       
                                    
       
    
});



