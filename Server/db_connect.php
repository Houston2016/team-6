<?php
 
/**
 * A class file to connect to database
 */
class DB_CONNECT {
 
    // constructor
    function __construct() {
        // connect to database
        $this->connect();
    }
 
    // destructor
    function __destruct() {
        // close db connection
        $this->close();
    }
 
    /**
     * connect with database
     */
    function connect() {
        // import database connection variables
        require_once __DIR__ . '/db_config.php';
 
        // connect to mysql database
        $con = mysql_connect(DB_SERVER, DB_USER, DB_PASSWORD) or die(mysql_error());
 
        // select database
        $db = mysql_select_db(DB_DATABASE) or die(mysql_error()) or die(mysql_error());
 
        // return connection cursor
        return $con;
    }
 
    /**
     * close db connection
     */
    function close() {
        // close db connection
        mysql_close();
    }
 
}
 
?>