<?php

/**
 * */

require_once 'include/DB_Functions.php';
$db = new DB_Functions();

// json response array
$response = array("error" => FALSE);

if (isset($_POST['email'])) {

    // receiving the post params
    $email = $_POST['email'];
    //$email="ss@ss";
	//$password = $_POST['password'];

    // get the user by email and password
    $user = $db->getUserAuth($email);

    if ($user != false) {
        // use is found
        $response["error"] = FALSE;
        
        echo json_encode($response);
    } else {
        // user is not found with the credentials
        $response["error"] = TRUE;
        $response["error_msg"] = "Please complete you payment!";
        echo json_encode($response);
    }
} else {
    // required post params is missing
    $response["error"] = TRUE;
    $response["error_msg"] = "Required parameters email or password is missing!";
    echo json_encode($response);
}
?>

