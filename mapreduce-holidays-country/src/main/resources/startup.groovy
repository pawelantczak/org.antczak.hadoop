if (!fsh.test(inputDir)) {
    fsh.mkdir(inputDir);
    fsh.chmod(700, inputDir)
}
if (fsh.test(outputDir)) {
   fsh.rmr(outputDir)
}
if (!fsh.test("/tmp")) {
    fsh.mkdir("/tmp")
    fsh.chmod("a+w", "/tmp")
}
if (!fsh.test("/user/hive/warehouse")) {
    fsh.mkdir("/user/hive/warehouse")
    fsh.chmod("a+w", "/user/hive/warehouse")
}