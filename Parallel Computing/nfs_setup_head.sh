set -x
sudo yum -y install nfs-utils

sudo systemctl enable nfs-server.service
sudo systemctl start nfs-server.service

sudo mkdir /software
sudo chmod 777 /software
sudo mv /local/repository/exports /etc/exports

sudo exportfs -a

sudo mkdir -p /scratch

sleep 15m

sudo mount 192.168.1.3:/scratch /scratch

