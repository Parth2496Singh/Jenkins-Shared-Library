def call(String DockerImage, String ImageTag){
  sh "docker build -t ${DockerImage}:${ImageTag} ."
}                              
