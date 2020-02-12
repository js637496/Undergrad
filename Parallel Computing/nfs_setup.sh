set -x
sudo yum -y install nfs-utils

sudo mkdir -p /software
sudo mkdir -p /scratch

sleep 15m

sudo mount 192.168.1.1:/software /software
sudo mount 192.168.1.3:/scratch /scratch

sudo mv /local/repository/fstab /etc/fstab

echo "export PATH='$PATH:/software/openmpi/3.1.2/bin'" >> ~/.bashrc
echo "export LD_LIBRARY_PATH='$LD_LIBRARY_PATH:/software/openmpi/3.1.2/lib/'" >> ~/.bashrc
