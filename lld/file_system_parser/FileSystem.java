package lld.file_system_parser;

import java.util.*;

/**
 * you are asked to design a simplified file system that supports creating paths and retrieving their values
 * 
 * implement the FileSystem class:
 * 
 * @constructor
 * FileSystem() -> initializes the filesystem
 * 
 * @method
 * boolean createPath(String path, int value):
 * - path is an absolute path starting with '/'
 * - a path consists of one or more lowercase English letters separated by '/'
 * - the path must not already exist
 * - the parent directory of path must already exist (except the root '/')
 * - if path is successfully created, return true, else false
 * 
 * @method
 * int get(String path)
 * - returns the value aassociated with the given path
 * - if path exists, return its value
 * - if the path does not exist, return -1
 */
class FileSystem {
    Map<String, Integer> paths;

    public FileSystem() {
        this.paths = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        if (paths.containsKey(path)) {
            return false;
        }

        int lastSlashIdx = path.lastIndexOf("/");
        String parent = path.substring(0, lastSlashIdx);

        if(parent.isEmpty() || !paths.containsKey(parent)) {
            return false;
        }

        paths.put(path, value);
        return true;
    }

    public int get(String path) {
        return paths.getOrDefault(path, -1);
    }

    public static void main(String[] args) {
    }
}