# Import the Portal object.
import geni.portal as portal
# Import the ProtoGENI library.
import geni.rspec.pg as pg
import geni.rspec.igext as IG

# Create a portal context.
pc = portal.Context()

# Create a Request object to start building the RSpec.
request = pc.makeRequestRSpec()


tourDescription = \
"""
This profile provides the template for a full research cluster with head node, scheduler, compute nodes, and shared file systems.
First node (head) should contain:
- Shared home directory using Networked File System
- Management server for SLURM
Second node (metadata) should contain:
- Metadata server for SLURM
Third node (storage):
- Shared software directory (/software) using Networked File System
Remaining three nodes (computing):
- Compute nodes
"""

#
# Setup the Tour info with the above description and instructions.
#
tour = IG.Tour()
tour.Description(IG.Tour.TEXT,tourDescription)
request.addTour(tour)

prefixForIP = "192.168.1."

link = request.LAN("lan")

#reduce to head, meta, storage and 3 compute for testing
for i in range(15):
  if i == 0:
    node = request.XenVM("head")
    node.routable_control_ip = "true"
    node.addService(pg.Execute(shell="sh", command="sudo chmod 755 /local/repository/nfs_setup_head.sh"))
    node.addService(pg.Execute(shell="sh", command="sudo /local/repository/nfs_setup_head.sh"))
    #leaving out mpi while testing nfs setup
    node.addService(pg.Execute(shell="sh", command="sudo chmod 755 /local/repository/install_mpi.sh"))
    node.addService(pg.Execute(shell="sh", command="sudo /local/repository/install_mpi.sh"))
  elif i == 1:
    node = request.XenVM("metadata")
    node.addService(pg.Execute(shell="sh", command="sudo chmod 755 /local/repository/nfs_setup.sh"))
    node.addService(pg.Execute(shell="sh", command="sudo /local/repository/nfs_setup.sh"))
  elif i == 2:
    node = request.XenVM("storage")
    node.addService(pg.Execute(shell="sh", command="sudo chmod 755 /local/repository/nfs_setup_storage.sh"))
    node.addService(pg.Execute(shell="sh", command="sudo /local/repository/nfs_setup_storage.sh"))
    node.addService(pg.Execute(shell="sh", command="sudo su -c 'cp /local/repository/source/* /scratch'"))
    node.addService(pg.Execute(shell="sh", command="sudo su -c 'cp /local/repository/slurm.conf /scratch/slurm.conf'"))
    node.addService(pg.Execute(shell="sh", command="sudo su -c 'cp /local/repository/slurmdbd.conf /scratch/slurmdbd.conf'"))
    node.addService(pg.Execute(shell="sh", command="sudo su -c 'cp /local/repository/hellobatch.sh /scratch/hellobatch.sh'"))
    node.addService(pg.Execute(shell="sh", command="sudo su -c 'cp /local/repository/pibatch.sh /scratch/pibatch.sh'"))
  else:
    node = request.XenVM("compute-" + str(i-2))
    node.cores = 4
    node.ram = 4096
    node.addService(pg.Execute(shell="sh", command="sudo chmod 755 /local/repository/nfs_setup.sh"))
    node.addService(pg.Execute(shell="sh", command="sudo /local/repository/nfs_setup.sh"))

  node.disk_image = "urn:publicid:IDN+emulab.net+image+emulab-ops:CENTOS7-64-STD"

  iface = node.addInterface("if" + str(i))
  iface.component_id = "eth1"
  iface.addAddress(pg.IPv4Address(prefixForIP + str(i + 1), "255.255.255.0"))
  link.addInterface(iface)

  node.addService(pg.Execute(shell="sh", command="sudo chmod 755 /local/repository/passwordless.sh"))
  node.addService(pg.Execute(shell="sh", command="sudo /local/repository/passwordless.sh"))
  
  node.addService(pg.Execute(shell="sh", command="sudo chmod 755 /local/repository/slurm_setup.sh"))
  node.addService(pg.Execute(shell="sh", command="sudo /local/repository/slurm_setup.sh"))

  #Start the daemons
  if i == 1:
      node.addService(pg.Execute(shell="sh", command="sudo chmod 755 /local/repository/meta_daemon.sh"))
      node.addService(pg.Execute(shell="sh", command="sudo /local/repository/meta_daemon.sh"))
  elif i == 0:
      node.addService(pg.Execute(shell="sh", command="sudo chmod 755 /local/repository/head_daemon.sh"))
      node.addService(pg.Execute(shell="sh", command="sudo /local/repository/head_daemon.sh"))
  else:
      node.addService(pg.Execute(shell="sh", command="sudo chmod 755 /local/repository/compute_daemon.sh"))
      node.addService(pg.Execute(shell="sh", command="sudo /local/repository/compute_daemon.sh"))

# Print the RSpec to the enclosing page.
pc.printRequestRSpec(request)
