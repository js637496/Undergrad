#!/bin/bash

while [ ! -f /scratch/munge.key ]
do
  sleep 10
done
sudo cp /scratch/munge.key /etc/munge/munge.key
sudo chown munge: /etc/munge/munge.key
sudo chmod 400 /etc/munge/munge.key

#correct permissions
sudo chown -R munge: /etc/munge/ /var/log/munge/
sudo chmod 0700 /etc/munge/ /var/log/munge/

#wait for meta to have key before starting munge



while [ ! -f /scratch/meta.haskey ]
do
  sleep 10
done

sudo systemctl enable munge
sudo systemctl start munge

#install slurm
while [ ! -f /scratch/rpm.done ]
do
  sleep 10
done

sudo yum --nogpgcheck localinstall /software/slurm-rpms/* -y

#compute configuration
sudo cp /scratch/slurm.conf /etc/slurm/slurm.conf
sudo mkdir /var/spool/slurmd
sudo chown slurm: /var/spool/slurmd
sudo chmod 755 /var/spool/slurmd
sudo touch /var/log/slurmd.log
sudo chown slurm: /var/log/slurmd.log

#enable slurm daemon
while [ ! -f /scratch/metadb.done ]
do
  sleep 5
done
sudo systemctl enable slurmd
sudo systemctl start slurmd
sudo touch /scratch/compute.done
